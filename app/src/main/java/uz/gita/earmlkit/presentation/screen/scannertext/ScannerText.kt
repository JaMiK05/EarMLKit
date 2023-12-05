package uz.gita.earmlkit.presentation.screen.scannertext

import android.os.Bundle
import android.view.View
import androidx.camera.core.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import uz.gita.earmlkit.R
import uz.gita.earmlkit.databinding.ScreenScannerBinding
import uz.gita.earmlkit.util.camera.*


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

        val preview = binding.viewFinder
        startCamera(
            context = requireContext(),
            previews = preview,
            analys = YourImageAnalyzer(),
            lifecycle = viewLifecycleOwner,
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        )
    }

    override fun onDetach() {
        unbindCamera()
        super.onDetach()
    }

}

@ExperimentalGetImage
private class YourImageAnalyzer : ImageAnalysis.Analyzer {
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            recognizer.process(image).addOnSuccessListener { visionText ->
                textLiveData.value = visionText.text
            }.addOnFailureListener { e ->
            }
        }
        imageProxy.close()
    }
}