package edu.udelp.music.player

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import edu.udelp.music.data.remote.dto.ItemDto
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicPlayerManager @Inject constructor(
    private val exoPlayer: ExoPlayer
) {
    private val _currentTrack = mutableStateOf<ItemDto?>(null)
    val currentTrack: State<ItemDto?> = _currentTrack
    
    private val _isPlaying = mutableStateOf(false)
    val isPlaying: State<Boolean> = _isPlaying

    private var playlist: List<ItemDto> = emptyList()
    private var currentIndex: Int = -1

    fun playTrack(item: ItemDto, newPlaylist: List<ItemDto> = emptyList()) {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post {
            try {
                if (newPlaylist.isNotEmpty()) {
                    playlist = newPlaylist
                    currentIndex = playlist.indexOfFirst { it.id == item.id }
                } else if (playlist.isEmpty() || !playlist.contains(item)) {
                    playlist = listOf(item)
                    currentIndex = 0
                } else {
                    currentIndex = playlist.indexOfFirst { it.id == item.id }
                }

                _currentTrack.value = item
                
                val url = if (!item.streamUrl.isNullOrBlank()) {
                    item.streamUrl
                } else {
                    val encodedTitle = Uri.encode(item.title)
                    "${edu.udelp.music.BuildConfig.BASE_URL}api/v1/streaming/$encodedTitle.mp3"
                }
                
                val mediaItem = MediaItem.fromUri(url)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.prepare()
                exoPlayer.play()
                _isPlaying.value = true
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun skipNext() {
        if (playlist.isNotEmpty() && currentIndex < playlist.size - 1) {
            playTrack(playlist[currentIndex + 1])
        }
    }

    fun skipPrevious() {
        if (playlist.isNotEmpty() && currentIndex > 0) {
            playTrack(playlist[currentIndex - 1])
        }
    }

    fun addToQueue(item: ItemDto) {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post {
            val currentPlaylist = playlist.toMutableList()
            if (!currentPlaylist.any { it.id == item.id }) {
                currentPlaylist.add(item)
                playlist = currentPlaylist
                if (currentIndex == -1) {
                    currentIndex = 0
                    _currentTrack.value = item
                }
            }
        }
    }

    fun togglePlayPause() {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post {
            if (exoPlayer.isPlaying) {
                exoPlayer.pause()
                _isPlaying.value = false
            } else {
                exoPlayer.play()
                _isPlaying.value = true
            }
        }
    }

    fun release() {
        exoPlayer.release()
    }
}
