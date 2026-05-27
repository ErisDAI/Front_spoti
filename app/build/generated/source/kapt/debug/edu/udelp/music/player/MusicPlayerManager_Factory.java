package edu.udelp.music.player;

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
public final class MusicPlayerManager_Factory implements Factory<MusicPlayerManager> {
  private final Provider<Context> contextProvider;

  public MusicPlayerManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MusicPlayerManager get() {
    return newInstance(contextProvider.get());
  }

  public static MusicPlayerManager_Factory create(Provider<Context> contextProvider) {
    return new MusicPlayerManager_Factory(contextProvider);
  }

  public static MusicPlayerManager newInstance(Context context) {
    return new MusicPlayerManager(context);
  }
}
