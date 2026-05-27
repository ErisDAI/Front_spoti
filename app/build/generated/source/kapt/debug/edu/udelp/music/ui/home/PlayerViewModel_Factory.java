package edu.udelp.music.ui.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.player.MusicPlayerManager;
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
public final class PlayerViewModel_Factory implements Factory<PlayerViewModel> {
  private final Provider<MusicPlayerManager> playerManagerProvider;

  public PlayerViewModel_Factory(Provider<MusicPlayerManager> playerManagerProvider) {
    this.playerManagerProvider = playerManagerProvider;
  }

  @Override
  public PlayerViewModel get() {
    return newInstance(playerManagerProvider.get());
  }

  public static PlayerViewModel_Factory create(Provider<MusicPlayerManager> playerManagerProvider) {
    return new PlayerViewModel_Factory(playerManagerProvider);
  }

  public static PlayerViewModel newInstance(MusicPlayerManager playerManager) {
    return new PlayerViewModel(playerManager);
  }
}
