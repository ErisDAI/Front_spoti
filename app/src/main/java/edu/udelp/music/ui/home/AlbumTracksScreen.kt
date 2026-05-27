package edu.udelp.music.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.udelp.music.data.remote.dto.ItemDto

@Composable
fun AlbumTracksScreen(
    albumId: String,
    onBack: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
    playerViewModel: PlayerViewModel = hiltViewModel()
) {
    var tracks by remember { mutableStateOf<List<ItemDto>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(albumId) {
        try {
            tracks = homeViewModel.api.getAlbumTracks(albumId)
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
                title = { Text("Canciones del Álbum") },
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

@Composable
fun TrackListItem(
    track: ItemDto,
    onPlay: () -> Unit,
    onAddToQueue: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    ListItem(
        headlineContent = { Text(track.title, fontWeight = FontWeight.Bold, color = Color.Black) },
        supportingContent = { Text(track.subtitle, color = Color.Gray) },
        colors = ListItemDefaults.colors(containerColor = Color.White),
        modifier = Modifier.clickable { onPlay() },
        trailingContent = {
            Box {
                IconButton(onClick = { showMenu = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Opciones", tint = Color.Black)
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    DropdownMenuItem(
                        text = { Text("Añadir a la cola", color = Color.Black) },
                        onClick = {
                            onAddToQueue()
                            showMenu = false
                        }
                    )
                }
            }
        }
    )
}
