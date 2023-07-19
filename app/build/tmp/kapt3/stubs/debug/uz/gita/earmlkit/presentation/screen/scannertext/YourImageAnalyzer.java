package uz.gita.earmlkit.presentation.screen.scannertext;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Luz/gita/earmlkit/presentation/screen/scannertext/YourImageAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "()V", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "getRecognizer", "()Lcom/google/mlkit/vision/text/TextRecognizer;", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app_debug"})
@androidx.camera.core.ExperimentalGetImage
final class YourImageAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull
    private final com.google.mlkit.vision.text.TextRecognizer recognizer = null;
    
    public YourImageAnalyzer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.mlkit.vision.text.TextRecognizer getRecognizer() {
        return null;
    }
    
    @java.lang.Override
    public void analyze(@org.jetbrains.annotations.NotNull
    androidx.camera.core.ImageProxy imageProxy) {
    }
}