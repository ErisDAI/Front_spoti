package edu.udelp.music.player;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Ledu/udelp/music/player/MusicPlayerManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentTrack", "Landroidx/compose/runtime/MutableState;", "Ledu/udelp/music/data/remote/dto/ItemDto;", "_isPlaying", "", "currentIndex", "", "currentTrack", "Landroidx/compose/runtime/State;", "getCurrentTrack", "()Landroidx/compose/runtime/State;", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "isPlaying", "playlist", "", "addToQueue", "", "item", "getPlayer", "playTrack", "newPlaylist", "release", "skipNext", "skipPrevious", "togglePlayPause", "app_debug"})
public final class MusicPlayerManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.media3.exoplayer.ExoPlayer exoPlayer;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<edu.udelp.music.data.remote.dto.ItemDto> _currentTrack = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<edu.udelp.music.data.remote.dto.ItemDto> currentTrack = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _isPlaying = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.Boolean> isPlaying = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<edu.udelp.music.data.remote.dto.ItemDto> playlist;
    private int currentIndex = -1;
    
    @javax.inject.Inject()
    public MusicPlayerManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<edu.udelp.music.data.remote.dto.ItemDto> getCurrentTrack() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Boolean> isPlaying() {
        return null;
    }
    
    private final androidx.media3.exoplayer.ExoPlayer getPlayer() {
        return null;
    }
    
    public final void playTrack(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.dto.ItemDto item, @org.jetbrains.annotations.NotNull()
    java.util.List<edu.udelp.music.data.remote.dto.ItemDto> newPlaylist) {
    }
    
    public final void skipNext() {
    }
    
    public final void skipPrevious() {
    }
    
    public final void addToQueue(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.dto.ItemDto item) {
    }
    
    public final void togglePlayPause() {
    }
    
    public final void release() {
    }
}