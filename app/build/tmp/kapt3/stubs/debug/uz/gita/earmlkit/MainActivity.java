package uz.gita.earmlkit;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Luz/gita/earmlkit/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "navigationHandler", "Luz/gita/earmlkit/util/navigation/NavigationHandler;", "getNavigationHandler", "()Luz/gita/earmlkit/util/navigation/NavigationHandler;", "setNavigationHandler", "(Luz/gita/earmlkit/util/navigation/NavigationHandler;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public uz.gita.earmlkit.util.navigation.NavigationHandler navigationHandler;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final uz.gita.earmlkit.util.navigation.NavigationHandler getNavigationHandler() {
        return null;
    }
    
    public final void setNavigationHandler(@org.jetbrains.annotations.NotNull
    uz.gita.earmlkit.util.navigation.NavigationHandler p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}