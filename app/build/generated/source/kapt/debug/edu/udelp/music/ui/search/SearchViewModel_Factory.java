package edu.udelp.music.ui.search;

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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<CatalogApi> apiProvider;

  public SearchViewModel_Factory(Provider<CatalogApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(apiProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<CatalogApi> apiProvider) {
    return new SearchViewModel_Factory(apiProvider);
  }

  public static SearchViewModel newInstance(CatalogApi api) {
    return new SearchViewModel(api);
  }
}
