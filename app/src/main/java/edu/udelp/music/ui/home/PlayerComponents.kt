package edu.udelp.music.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import edu.udelp.music.player.MusicPlayerManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause

@HiltViewModel
class PlayerViewModel @Inject constructor(
    val playerManager: MusicPlayerManager
) : ViewModel() {
    
    // Obtenemos el estado directamente del manager que ya es reactivo
    val isPlaying: State<Boolean> = playerManager.isPlaying

    fun togglePlayPause() {
        playerManager.togglePlayPause()
    }

    fun skipNext() {
        playerManager.skipNext()
    }

    fun skipPrevious() {
        playerManager.skipPrevious()
    }
}

@Composable
fun MiniPlayer(
    trackTitle: String,
    streamUrl: String,
    viewModel: PlayerViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val isPlaying by viewModel.isPlaying

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp), // Un poco más alto para mejor UX
        color = androidx.compose.ui.graphics.Color.White, // Fondo blanco
        shadowElevation = 8.dp,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = trackTitle, 
                    style = MaterialTheme.typography.bodyLarge,
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = "Reproduciendo ahora", 
                    style = MaterialTheme.typography.bodySmall,
                    color = androidx.compose.ui.graphics.Color.Gray
                )
            }
            
            IconButton(onClick = { viewModel.togglePlayPause() }) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = androidx.compose.ui.graphics.Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
