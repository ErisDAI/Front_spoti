package edu.udelp.music.player;

import androidx.media3.exoplayer.ExoPlayer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class MusicPlayerManager_Factory implements Factory<MusicPlayerManager> {
  private final Provider<ExoPlayer> exoPlayerProvider;

  public MusicPlayerManager_Factory(Provider<ExoPlayer> exoPlayerProvider) {
    this.exoPlayerProvider = exoPlayerProvider;
  }

  @Override
  public MusicPlayerManager get() {
    return newInstance(exoPlayerProvider.get());
  }

  public static MusicPlayerManager_Factory create(Provider<ExoPlayer> exoPlayerProvider) {
    return new MusicPlayerManager_Factory(exoPlayerProvider);
  }

  public static MusicPlayerManager newInstance(ExoPlayer exoPlayer) {
    return new MusicPlayerManager(exoPlayer);
  }
}
