package edu.udelp.music.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.udelp.music.data.remote.dto.ItemDto

@Composable
fun ArtistTracksScreen(
    artistId: String,
    onBack: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
    playerViewModel: PlayerViewModel = hiltViewModel()
) {
    var tracks by remember { mutableStateOf<List<ItemDto>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(artistId) {
        try {
            tracks = homeViewModel.api.getArtistTracks(artistId)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = { Text("Canciones del Artista") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding).background(Color.White)) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Color.Black)
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(tracks) { track ->
                        TrackListItem(
                            track = track,
                            onPlay = { playerViewModel.playerManager.playTrack(track, tracks) },
                            onAddToQueue = { playerViewModel.playerManager.addToQueue(track) }
                        )
                    }
                }
            }
        }
    }
}
