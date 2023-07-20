package uz.gita.earmlkit.presentation.screen.scanbarcodefragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.earmlkit.R
import uz.gita.earmlkit.databinding.ScreenScanefaceBinding
import uz.gita.earmlkit.util.camera.startCamera
import uz.gita.earmlkit.util.camera.unbindCamera

/**
 *   Created by Jamik on 7/19/2023 ot 9:51 PM
 **/
@AndroidEntryPoint
class ScanFaceFragment : Fragment(R.layout.screen_scaneface) {

    private val binding by viewBinding(ScreenScanefaceBinding::bind)
    private var dialogParceUri: ScanBarCodeDialog? = null
    private var time = 0
    private val scope = lifecycleScope
    private var barcode = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preview = binding.viewFinder
        timeManage()
        startCamera(
            context = requireContext(),
            previews = preview,
            analys = BarcodeScanningAnalyzer { barcodes, width, height ->
                binding.apply {
                    txt.visibility = View.GONE
                    val resultText =
                        barcodes.joinToString(separator = "\n") { it.displayValue.toString() }
                    if (resultText.startsWith("https://") && barcode != resultText) {
                        dialogParceUri?.dismiss()
                        dialogParceUri = null
                        barcode = resultText
                        dialogParceUri = ScanBarCodeDialog(requireContext(), resultText)
                        dialogParceUri?.setListener {
                            requireActivity().startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(resultText)
                                )
                            )
                            dialogParceUri?.dismiss()
                        }
                        dialogParceUri?.setCancelListener {
                            barcode = ""
                        }
                        txt.visibility = View.GONE
                        dialogParceUri?.show()
                        time = 0
                    } else if (barcode == resultText) {
                        txt.text = ""
                    } else {
                        if (txt.text != resultText) {
                            txt.visibility = View.VISIBLE
                            txt.text = resultText
                            time = 0
                        }
                    }
                }
            },
            lifecycle = viewLifecycleOwner,
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        )
    }

    override fun onDetach() {
        scope.cancel()
        unbindCamera()
        super.onDetach()
    }


    private fun timeManage() {
        scope.launch {
            while (true) {
                delay(1000)
                time += 1
                if (time == 10) {
                    binding.apply {
                        txt.text = ""
                    }
                    dialogParceUri?.dismiss()
                    dialogParceUri = null
                }
            }
        }
    }
}

@SuppressLint("UnsafeOptInUsageError")
class BarcodeScanningAnalyzer(
    private val onBarcodeDetected: (barcodes: MutableList<Barcode>, width: Int, height: Int) -> Unit,
) : ImageAnalysis.Analyzer {

    private val options = BarcodeScannerOptions.Builder().build()

    private val scanner = BarcodeScanning.getClient(options)

    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.image?.let {
            val imageValue = InputImage.fromMediaImage(it, imageProxy.imageInfo.rotationDegrees)
            scanner.process(imageValue)
                .addOnSuccessListener { barcodes ->
                    onBarcodeDetected(barcodes, imageValue.height, imageValue.width)
                }
                .addOnFailureListener { failure ->
                    failure.printStackTrace()
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }
}