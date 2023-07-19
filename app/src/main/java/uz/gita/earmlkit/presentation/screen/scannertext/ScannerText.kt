package uz.gita.earmlkit.presentation.screen.scannertext

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import uz.gita.earmlkit.R
import uz.gita.earmlkit.databinding.ScreenScannerBinding
import java.util.concurrent.Executors

private val textLiveData = MutableLiveData<String>()

@ExperimentalGetImage
class ScannerText : Fragment(R.layout.screen_scanner) {

    private val binding by viewBinding(ScreenScannerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textLiveData.observe(viewLifecycleOwner) { text ->
            binding.apply {
                scantxt.text = text
            }
        }
        startCamera()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(requireView().findViewById<PreviewView>(R.id.viewFinder).surfaceProvider)
                }

            val imageAnalyzer = ImageAnalysis.Builder()
                .build()
                .also {
                    it.setAnalyzer(Executors.newSingleThreadExecutor(), YourImageAnalyzer())
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalyzer)

            } catch (exc: Exception) {
                Log.e("TTT", "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }
}

@ExperimentalGetImage
private class YourImageAnalyzer : ImageAnalysis.Analyzer {
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            // ...
            val result = recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    textLiveData.value = visionText.text
                }
                .addOnFailureListener { e ->
                }
        }
        imageProxy.close()
    }
}
