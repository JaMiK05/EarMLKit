package uz.gita.earmlkit.util.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NavigationDispatcher_Factory implements Factory<NavigationDispatcher> {
  @Override
  public NavigationDispatcher get() {
    return newInstance();
  }

  public static NavigationDispatcher_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NavigationDispatcher newInstance() {
    return new NavigationDispatcher();
  }

  private static final class InstanceHolder {
    private static final NavigationDispatcher_Factory INSTANCE = new NavigationDispatcher_Factory();
  }
}
