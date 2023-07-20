package uz.gita.earmlkit.util.camera

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.Executors

@SuppressLint("StaticFieldLeak")
private var cameraProvider: ProcessCameraProvider? = null
private var camera: Camera? = null

fun startCamera(
    context: Context,
    previews: PreviewView,
    analys: ImageAnalysis.Analyzer,
    lifecycle: LifecycleOwner,
    cameraSelector: CameraSelector,
) {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

    cameraProviderFuture.addListener({
        cameraProvider = ProcessCameraProvider.getInstance(context).get()

        val preview = Preview.Builder()
            .build()
            .also {
                it.setSurfaceProvider(previews.surfaceProvider)
            }

        val imageAnalyzer = ImageAnalysis.Builder()
            .build()
            .also {
                it.setAnalyzer(Executors.newSingleThreadExecutor(), analys)
            }

        try {
            cameraProvider?.unbindAll()
            camera =
                cameraProvider?.bindToLifecycle(lifecycle, cameraSelector, preview, imageAnalyzer)

        } catch (exc: Exception) {
            Log.e("TTT", "Use case binding failed", exc)
        }

    }, ContextCompat.getMainExecutor(context))
}

fun unbindCamera() {
    cameraProvider?.apply {
        unbindAll()
    }
    camera = null
}
