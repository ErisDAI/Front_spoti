package edu.udelp.music.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.local.SessionManager;
import edu.udelp.music.data.remote.AuthApi;
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
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<AuthApi> apiProvider;

  private final Provider<SessionManager> sessionManagerProvider;

  public AuthRepositoryImpl_Factory(Provider<AuthApi> apiProvider,
      Provider<SessionManager> sessionManagerProvider) {
    this.apiProvider = apiProvider;
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(apiProvider.get(), sessionManagerProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<AuthApi> apiProvider,
      Provider<SessionManager> sessionManagerProvider) {
    return new AuthRepositoryImpl_Factory(apiProvider, sessionManagerProvider);
  }

  public static AuthRepositoryImpl newInstance(AuthApi api, SessionManager sessionManager) {
    return new AuthRepositoryImpl(api, sessionManager);
  }
}
