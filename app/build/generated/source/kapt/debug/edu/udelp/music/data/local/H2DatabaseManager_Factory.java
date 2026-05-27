package edu.udelp.music.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class H2DatabaseManager_Factory implements Factory<H2DatabaseManager> {
  private final Provider<Context> contextProvider;

  public H2DatabaseManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public H2DatabaseManager get() {
    return newInstance(contextProvider.get());
  }

  public static H2DatabaseManager_Factory create(Provider<Context> contextProvider) {
    return new H2DatabaseManager_Factory(contextProvider);
  }

  public static H2DatabaseManager newInstance(Context context) {
    return new H2DatabaseManager(context);
  }
}
