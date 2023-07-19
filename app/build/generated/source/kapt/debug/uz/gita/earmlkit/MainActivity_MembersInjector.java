package uz.gita.earmlkit;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import uz.gita.earmlkit.util.navigation.NavigationHandler;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<NavigationHandler> navigationHandlerProvider;

  public MainActivity_MembersInjector(Provider<NavigationHandler> navigationHandlerProvider) {
    this.navigationHandlerProvider = navigationHandlerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<NavigationHandler> navigationHandlerProvider) {
    return new MainActivity_MembersInjector(navigationHandlerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectNavigationHandler(instance, navigationHandlerProvider.get());
  }

  @InjectedFieldSignature("uz.gita.earmlkit.MainActivity.navigationHandler")
  public static void injectNavigationHandler(MainActivity instance,
      NavigationHandler navigationHandler) {
    instance.navigationHandler = navigationHandler;
  }
}
