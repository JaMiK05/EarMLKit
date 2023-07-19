package uz.gita.earmlkit.presentation.screen.homefragment;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import uz.gita.earmlkit.util.navigation.AppNavigator;

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
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<AppNavigator> navigatorProvider;

  public HomeFragment_MembersInjector(Provider<AppNavigator> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  public static MembersInjector<HomeFragment> create(Provider<AppNavigator> navigatorProvider) {
    return new HomeFragment_MembersInjector(navigatorProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    injectNavigator(instance, navigatorProvider.get());
  }

  @InjectedFieldSignature("uz.gita.earmlkit.presentation.screen.homefragment.HomeFragment.navigator")
  public static void injectNavigator(HomeFragment instance, AppNavigator navigator) {
    instance.navigator = navigator;
  }
}
