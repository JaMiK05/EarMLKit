package uz.gita.earmlkit.presentation.screen.scanbody

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.PoseLandmark
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.earmlkit.R
import uz.gita.earmlkit.databinding.ScreenBodyBinding
import uz.gita.earmlkit.util.camera.startCamera
import uz.gita.earmlkit.util.camera.unbindCamera
import kotlin.math.abs
import kotlin.math.atan2

@ExperimentalGetImage
/**
 *   Created by Jamik on 7/21/2023 ot 1:11 PM
 **/
@AndroidEntryPoint
class ScanBody : Fragment(R.layout.screen_body) {

    private val binding by viewBinding(ScreenBodyBinding::bind)

    private lateinit var textView: TextView

    private lateinit var rectoverlay: Reactsoverlaoy

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preview = binding.preview
        textView = binding.textViewId

        rectoverlay = binding.rectOverlay

        startCamera(
            context = requireContext(),
            previews = preview,
            analys = PoseAnalyzer(::onTextFound),
            lifecycle = viewLifecycleOwner,
            cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        )
    }

    private fun getAngle(
        firstPoint: PoseLandmark,
        midPoint: PoseLandmark,
        lastPoint: PoseLandmark,
    ): Double {

        var result = Math.toDegrees(
            atan2(
                lastPoint.position.y.toDouble() - midPoint.position.y,
                lastPoint.position.x.toDouble() - midPoint.position.x
            )
                    - atan2(
                firstPoint.position.y - midPoint.position.y,
                firstPoint.position.x - midPoint.position.x
            )
        )
        result = Math.abs(result) // Angle should never be negative
        if (result > 180) {
            result = 360.0 - result // Always get the acute representation of the angle
        }
        return result
    }


    private fun getNeckAngle(
        orecchio: PoseLandmark, spalla: PoseLandmark,
    ): Double {

        var result = Math.toDegrees(
            atan2(
                spalla.position.y.toDouble() - spalla.position.y,
                (spalla.position.x + 100).toDouble() - spalla.position.x
            )
                    - atan2(
                orecchio.position.y - spalla.position.y,
                orecchio.position.x - spalla.position.x
            )
        )

        result = abs(result) // Angle should never be negative

        if (result > 180) {
            result = 360.0 - result // Always get the acute representation of the angle
        }
        return result
    }

    private fun onTextFound(pose: Pose) {
        try {
            val leftShoulder = pose.getPoseLandmark(PoseLandmark.LEFT_SHOULDER)
            val rightShoulder = pose.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER)
            val leftElbow = pose.getPoseLandmark(PoseLandmark.LEFT_ELBOW)
            val rightElbow = pose.getPoseLandmark(PoseLandmark.RIGHT_ELBOW)
            val leftWrist = pose.getPoseLandmark(PoseLandmark.LEFT_WRIST)
            val rightWrist = pose.getPoseLandmark(PoseLandmark.RIGHT_WRIST)
            val leftHip = pose.getPoseLandmark(PoseLandmark.LEFT_HIP)
            val rightHip = pose.getPoseLandmark(PoseLandmark.RIGHT_HIP)
            val leftKnee = pose.getPoseLandmark(PoseLandmark.LEFT_KNEE)
            val rightKnee = pose.getPoseLandmark(PoseLandmark.RIGHT_KNEE)
            val leftAnkle = pose.getPoseLandmark(PoseLandmark.LEFT_ANKLE)
            val rightAnkle = pose.getPoseLandmark(PoseLandmark.RIGHT_ANKLE)

            val leftPinky = pose.getPoseLandmark(PoseLandmark.LEFT_PINKY)
            val rightPinky = pose.getPoseLandmark(PoseLandmark.RIGHT_PINKY)
            val leftIndex = pose.getPoseLandmark(PoseLandmark.LEFT_INDEX)
            val rightIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_INDEX)
            val leftThumb = pose.getPoseLandmark(PoseLandmark.LEFT_THUMB)
            val rightThumb = pose.getPoseLandmark(PoseLandmark.RIGHT_THUMB)
            val leftHeel = pose.getPoseLandmark(PoseLandmark.LEFT_HEEL)
            val rightHeel = pose.getPoseLandmark(PoseLandmark.RIGHT_HEEL)
            val leftFootIndex = pose.getPoseLandmark(PoseLandmark.LEFT_FOOT_INDEX)
            val rightFootIndex = pose.getPoseLandmark(PoseLandmark.RIGHT_FOOT_INDEX)

            val occhioSx = pose.getPoseLandmark(PoseLandmark.LEFT_EYE);
            val occhioDx = pose.getPoseLandmark(PoseLandmark.RIGHT_EYE);

            val orecchioDx = pose.getPoseLandmark(PoseLandmark.RIGHT_EAR);
            val orecchioSx = pose.getPoseLandmark(PoseLandmark.LEFT_EAR);

            val builder = StringBuilder()
            rectoverlay.clear()

            if (occhioSx != null && occhioDx != null && leftShoulder != null && rightShoulder != null) {
                rectoverlay.drawNeck(occhioSx, occhioDx, leftShoulder, rightShoulder);
            }

            if (orecchioSx != null && leftShoulder != null) {
                rectoverlay.drawLine(orecchioSx, leftShoulder)
                val angoloCollo = getNeckAngle(orecchioSx, leftShoulder);
                builder.append("${90 - angoloCollo.toInt()} collo (da sx) \n")
            }

            if (orecchioDx != null && rightShoulder != null) {
                rectoverlay.drawLine(orecchioDx, rightShoulder)
                val angoloCollo = getNeckAngle(orecchioDx, rightShoulder);
                builder.append("${90 - angoloCollo.toInt()} collo (da dx) \n")
            }

            if (rightShoulder != null && rightHip != null && rightKnee != null) {
                val angoloBusto = getAngle(rightShoulder, rightHip, rightKnee);
                builder.append("${180 - angoloBusto.toInt()} busto (da dx) \n")
            }

            if (leftShoulder != null && leftHip != null && leftKnee != null) {
                val angoloBusto = getAngle(leftShoulder, leftHip, leftKnee);
                builder.append("${180 - angoloBusto.toInt()} busto (da sx) \n")
            }


            if (rightHip != null && rightKnee != null && rightAnkle != null) {
                val angoloBusto = getAngle(rightHip, rightKnee, rightAnkle);
                builder.append("${180 - angoloBusto.toInt()} gamba (da dx) \n")
            }

            if (leftHip != null && leftKnee != null && leftAnkle != null) {
                val angoloBusto = getAngle(leftHip, leftKnee, leftAnkle);
                builder.append("${180 - angoloBusto.toInt()} gamba (da sx) \n")
            }


            if (leftShoulder != null && rightShoulder != null) {
                rectoverlay.drawLine(leftShoulder, rightShoulder)
            }

            if (leftHip != null && rightHip != null) {
                rectoverlay.drawLine(leftHip, rightHip)
            }

            if (leftShoulder != null && leftElbow != null) {
                rectoverlay.drawLine(leftShoulder, leftElbow)
            }

            if (leftElbow != null && leftWrist != null) {
                rectoverlay.drawLine(leftElbow, leftWrist)
            }

            if (leftShoulder != null && leftHip != null) {
                rectoverlay.drawLine(leftShoulder, leftHip)
            }

            if (leftHip != null && leftKnee != null) {
                rectoverlay.drawLine(leftHip, leftKnee)
            }

            if (leftKnee != null && leftAnkle != null) {
                rectoverlay.drawLine(leftKnee, leftAnkle)
            }

            if (leftWrist != null && leftThumb != null) {
                rectoverlay.drawLine(leftWrist, leftThumb)
            }

            if (leftWrist != null && leftPinky != null) {
                rectoverlay.drawLine(leftWrist, leftPinky)
            }

            if (leftWrist != null && leftIndex != null) {
                rectoverlay.drawLine(leftWrist, leftIndex)
            }

            if (leftIndex != null && leftPinky != null) {
                rectoverlay.drawLine(leftIndex, leftPinky)
            }

            if (leftAnkle != null && leftHeel != null) {
                rectoverlay.drawLine(leftAnkle, leftHeel)
            }

            if (leftHeel != null && leftFootIndex != null) {
                rectoverlay.drawLine(leftHeel, leftFootIndex)
            }

            if (rightShoulder != null && rightElbow != null) {
                rectoverlay.drawLine(rightShoulder, rightElbow)
            }

            if (rightElbow != null && rightWrist != null) {
                rectoverlay.drawLine(rightElbow, rightWrist)
            }

            if (rightShoulder != null && rightHip != null) {
                rectoverlay.drawLine(rightShoulder, rightHip)
            }

            if (rightHip != null && rightKnee != null) {
                rectoverlay.drawLine(rightHip, rightKnee)
            }

            if (rightKnee != null && rightAnkle != null) {
                rectoverlay.drawLine(rightKnee, rightAnkle)
            }

            if (rightWrist != null && rightThumb != null) {
                rectoverlay.drawLine(rightWrist, rightThumb)
            }

            if (rightWrist != null && rightPinky != null) {
                rectoverlay.drawLine(rightWrist, rightPinky)
            }

            if (rightWrist != null && rightIndex != null) {
                rectoverlay.drawLine(rightWrist, rightIndex)
            }

            if (rightIndex != null && rightPinky != null) {
                rectoverlay.drawLine(rightIndex, rightPinky)
            }

            if (rightAnkle != null && rightHeel != null) {
                rectoverlay.drawLine(rightAnkle, rightHeel)
            }

            if (rightHeel != null && rightFootIndex != null) {
                rectoverlay.drawLine(rightHeel, rightFootIndex)
            }


            textView.text = builder.toString()

        } catch (e: java.lang.Exception) {
            Toast.makeText(requireContext(), "Errore", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDetach() {
        unbindCamera()
        super.onDetach()
    }

}

@ExperimentalGetImage
private class PoseAnalyzer(private val poseFoundListener: (Pose) -> Unit) : ImageAnalysis.Analyzer {

    private val options = AccuratePoseDetectorOptions.Builder()
        .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
        .build()

    private val poseDetector = PoseDetection.getClient(options);

    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            // Accurate pose detector on static images, when depending on the pose-detection-accurate sdk
            poseDetector
                .process(image)
                .addOnSuccessListener { pose ->
                    poseFoundListener(pose)
                    imageProxy.close()
                }
                .addOnFailureListener { error ->
                    Log.d(ContentValues.TAG, "Failed to process the image")
                    error.printStackTrace()
                    imageProxy.close()
                }
        }
    }
}

class Reactsoverlaoy constructor(context: Context?, attributeSet: AttributeSet?) :
    View(context, attributeSet) {
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private val strokeWidth1 = 3f
    private val drawColor = Color.RED

    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = strokeWidth1 // default: Hairline-width (really thin)
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(Color.TRANSPARENT)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
    }

    fun clear() {
        extraCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    internal fun drawLine(
        startLandmark: PoseLandmark?,
        endLandmark: PoseLandmark?,
    ) {
        val start = startLandmark!!.position
        val end = endLandmark!!.position


        val xmul = 3.3f;
        val ymul = 3.3f;

        extraCanvas.drawLine(
            (start.x * xmul) - 250, start.y * ymul, (end.x * xmul) - 250, end.y * ymul, paint
        )
        invalidate();
    }

    internal fun drawNeck(
        _occhioSx: PoseLandmark?,
        _occhioDx: PoseLandmark?,
        _spallaSx: PoseLandmark?,
        _spallaDx: PoseLandmark?,
    ) {

        val xmul = 3.3f;
        val ymul = 3.3f;


        val occhioSx = _occhioSx!!.position
        val occhioDx = _occhioDx!!.position
        val spallaSx = _spallaSx!!.position
        val spallaDx = _spallaDx!!.position


        val fineColloX = occhioDx.x + ((occhioSx.x - occhioDx.x) / 2);
        val fineColloY = occhioDx.y + ((occhioSx.y - occhioDx.y) / 2);

        val inizioColloX = spallaDx.x + ((spallaSx.x - spallaDx.x) / 2);
        val inizioColloY = spallaDx.y + ((spallaSx.y - spallaDx.y) / 2);

        extraCanvas.drawLine(
            (fineColloX * xmul) - 250,
            fineColloY * ymul,
            (inizioColloX * xmul) - 250,
            inizioColloY * ymul,
            paint
        )

        extraCanvas.drawLine(
            (occhioSx.x * xmul) - 250,
            occhioSx.y * ymul,
            (occhioDx.x * xmul) - 250,
            occhioDx.y * ymul,
            paint
        )
        invalidate();
    }
}
