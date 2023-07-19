package uz.gita.earmlkit.presentation.screen.homefragment;

/**
 * Created by Jamik on 7/19/2023 ot 4:23 PM
 */
@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Luz/gita/earmlkit/presentation/screen/homefragment/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Luz/gita/earmlkit/databinding/HomeFragmentBinding;", "getBinding", "()Luz/gita/earmlkit/databinding/HomeFragmentBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "myPermissionRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "navigator", "Luz/gita/earmlkit/util/navigation/AppNavigator;", "getNavigator", "()Luz/gita/earmlkit/util/navigation/AppNavigator;", "setNavigator", "(Luz/gita/earmlkit/util/navigation/AppNavigator;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestPermission", "", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject
    public uz.gita.earmlkit.util.navigation.AppNavigator navigator;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> myPermissionRequest = null;
    @org.jetbrains.annotations.NotNull
    private final by.kirich1409.viewbindingdelegate.ViewBindingProperty binding$delegate = null;
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final uz.gita.earmlkit.util.navigation.AppNavigator getNavigator() {
        return null;
    }
    
    public final void setNavigator(@org.jetbrains.annotations.NotNull
    uz.gita.earmlkit.util.navigation.AppNavigator p0) {
    }
    
    private final boolean requestPermission() {
        return false;
    }
    
    private final uz.gita.earmlkit.databinding.HomeFragmentBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}