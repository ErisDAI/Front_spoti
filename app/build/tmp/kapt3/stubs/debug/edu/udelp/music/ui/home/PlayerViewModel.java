package edu.udelp.music.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Ledu/udelp/music/ui/home/PlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "playerManager", "Ledu/udelp/music/player/MusicPlayerManager;", "(Ledu/udelp/music/player/MusicPlayerManager;)V", "isPlaying", "Landroidx/compose/runtime/State;", "", "()Landroidx/compose/runtime/State;", "getPlayerManager", "()Ledu/udelp/music/player/MusicPlayerManager;", "skipNext", "", "skipPrevious", "togglePlayPause", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.udelp.music.player.MusicPlayerManager playerManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.Boolean> isPlaying = null;
    
    @javax.inject.Inject()
    public PlayerViewModel(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.player.MusicPlayerManager playerManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.udelp.music.player.MusicPlayerManager getPlayerManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Boolean> isPlaying() {
        return null;
    }
    
    public final void togglePlayPause() {
    }
    
    public final void skipNext() {
    }
    
    public final void skipPrevious() {
    }
}