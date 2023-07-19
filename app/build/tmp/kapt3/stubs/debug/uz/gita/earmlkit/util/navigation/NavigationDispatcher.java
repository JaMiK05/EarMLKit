package uz.gita.earmlkit.util.navigation;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\f\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u00020\b2\u001b\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0010\u00a2\u0006\u0002\b\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R+\u0010\u0004\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\t0\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Luz/gita/earmlkit/util/navigation/NavigationDispatcher;", "Luz/gita/earmlkit/util/navigation/AppNavigator;", "Luz/gita/earmlkit/util/navigation/NavigationHandler;", "()V", "navigationBuffer", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Function1;", "Landroidx/navigation/NavController;", "", "Lkotlin/ExtensionFunctionType;", "getNavigationBuffer", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "back", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigate", "args", "Luz/gita/earmlkit/util/navigation/NavigationArgs;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateTo", "screen", "Landroidx/navigation/NavDirections;", "Luz/gita/earmlkit/util/navigation/AppScreen;", "(Landroidx/navigation/NavDirections;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NavigationDispatcher implements uz.gita.earmlkit.util.navigation.AppNavigator, uz.gita.earmlkit.util.navigation.NavigationHandler {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<kotlin.jvm.functions.Function1<androidx.navigation.NavController, kotlin.Unit>> navigationBuffer = null;
    
    @javax.inject.Inject
    public NavigationDispatcher() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.MutableSharedFlow<kotlin.jvm.functions.Function1<androidx.navigation.NavController, kotlin.Unit>> getNavigationBuffer() {
        return null;
    }
    
    private final java.lang.Object navigate(kotlin.jvm.functions.Function1<? super androidx.navigation.NavController, kotlin.Unit> args, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object navigateTo(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavDirections screen, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object back(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}