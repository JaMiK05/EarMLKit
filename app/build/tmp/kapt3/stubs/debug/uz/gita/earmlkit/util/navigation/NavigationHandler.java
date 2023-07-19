package uz.gita.earmlkit.util.navigation;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R-\u0010\u0002\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007\u00a2\u0006\u0002\b\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Luz/gita/earmlkit/util/navigation/NavigationHandler;", "", "navigationBuffer", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "Landroidx/navigation/NavController;", "", "Luz/gita/earmlkit/util/navigation/NavigationArgs;", "Lkotlin/ExtensionFunctionType;", "getNavigationBuffer", "()Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public abstract interface NavigationHandler {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<kotlin.jvm.functions.Function1<androidx.navigation.NavController, kotlin.Unit>> getNavigationBuffer();
}