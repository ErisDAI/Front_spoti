package edu.udelp.music.ui.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.remote.CatalogApi;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<CatalogApi> apiProvider;

  public HomeViewModel_Factory(Provider<CatalogApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(apiProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<CatalogApi> apiProvider) {
    return new HomeViewModel_Factory(apiProvider);
  }

  public static HomeViewModel newInstance(CatalogApi api) {
    return new HomeViewModel(api);
  }
}
