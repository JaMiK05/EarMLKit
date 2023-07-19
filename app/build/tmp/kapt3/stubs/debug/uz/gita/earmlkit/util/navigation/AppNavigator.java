package uz.gita.earmlkit.util.navigation;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00032\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Luz/gita/earmlkit/util/navigation/AppNavigator;", "", "back", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateTo", "screen", "Landroidx/navigation/NavDirections;", "Luz/gita/earmlkit/util/navigation/AppScreen;", "(Landroidx/navigation/NavDirections;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AppNavigator {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object navigateTo(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavDirections screen, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object back(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}