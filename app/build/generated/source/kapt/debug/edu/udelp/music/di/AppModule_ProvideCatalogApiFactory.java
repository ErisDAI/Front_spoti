package edu.udelp.music.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.remote.CatalogApi;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideCatalogApiFactory implements Factory<CatalogApi> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public AppModule_ProvideCatalogApiFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public CatalogApi get() {
    return provideCatalogApi(okHttpClientProvider.get());
  }

  public static AppModule_ProvideCatalogApiFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new AppModule_ProvideCatalogApiFactory(okHttpClientProvider);
  }

  public static CatalogApi provideCatalogApi(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCatalogApi(okHttpClient));
  }
}
