package edu.udelp.music.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.local.SessionManager;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

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
public final class AppModule_ProvideAuthInterceptorFactory implements Factory<Interceptor> {
  private final Provider<SessionManager> sessionManagerProvider;

  public AppModule_ProvideAuthInterceptorFactory(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public Interceptor get() {
    return provideAuthInterceptor(sessionManagerProvider.get());
  }

  public static AppModule_ProvideAuthInterceptorFactory create(
      Provider<SessionManager> sessionManagerProvider) {
    return new AppModule_ProvideAuthInterceptorFactory(sessionManagerProvider);
  }

  public static Interceptor provideAuthInterceptor(SessionManager sessionManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthInterceptor(sessionManager));
  }
}
