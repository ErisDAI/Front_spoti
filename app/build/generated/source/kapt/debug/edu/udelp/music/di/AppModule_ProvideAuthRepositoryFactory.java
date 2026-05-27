package edu.udelp.music.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.local.SessionManager;
import edu.udelp.music.data.remote.AuthApi;
import edu.udelp.music.domain.repository.AuthRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<AuthApi> apiProvider;

  private final Provider<SessionManager> sessionManagerProvider;

  public AppModule_ProvideAuthRepositoryFactory(Provider<AuthApi> apiProvider,
      Provider<SessionManager> sessionManagerProvider) {
    this.apiProvider = apiProvider;
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(apiProvider.get(), sessionManagerProvider.get());
  }

  public static AppModule_ProvideAuthRepositoryFactory create(Provider<AuthApi> apiProvider,
      Provider<SessionManager> sessionManagerProvider) {
    return new AppModule_ProvideAuthRepositoryFactory(apiProvider, sessionManagerProvider);
  }

  public static AuthRepository provideAuthRepository(AuthApi api, SessionManager sessionManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepository(api, sessionManager));
  }
}
