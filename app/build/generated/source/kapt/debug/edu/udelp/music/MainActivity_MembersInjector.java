package edu.udelp.music;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import edu.udelp.music.player.MusicPlayerManager;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MusicPlayerManager> playerManagerProvider;

  public MainActivity_MembersInjector(Provider<MusicPlayerManager> playerManagerProvider) {
    this.playerManagerProvider = playerManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MusicPlayerManager> playerManagerProvider) {
    return new MainActivity_MembersInjector(playerManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectPlayerManager(instance, playerManagerProvider.get());
  }

  @InjectedFieldSignature("edu.udelp.music.MainActivity.playerManager")
  public static void injectPlayerManager(MainActivity instance, MusicPlayerManager playerManager) {
    instance.playerManager = playerManager;
  }
}
