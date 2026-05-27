package edu.udelp.music.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.hilt.navigation.compose.hiltViewModel
import edu.udelp.music.data.remote.dto.HomeContentDto
import edu.udelp.music.data.remote.dto.ItemDto
import edu.udelp.music.data.remote.dto.SectionDto
import edu.udelp.music.player.MusicPlayerManager

@Composable
fun HomeScreen(
    content: HomeContentDto,
    onExpandPlayer: () -> Unit,
    onArtistClick: (String) -> Unit,
    onAlbumClick: (String) -> Unit,
    playerViewModel: PlayerViewModel = hiltViewModel()
) {
    val playerManager = playerViewModel.playerManager

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp, start = 16.dp, end = 16.dp, top = 32.dp)
        ) {
            item {
                Text(
                    text = "¡Buenas tardes!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            items(content.sections) { section ->
                SectionView(
                    section = section, 
                    onItemClick = { item ->
                        when (item.type) {
                            "TRACK" -> playerManager.playTrack(item, section.items.filter { it.type == "TRACK" })
                            "ARTIST" -> onArtistClick(item.id)
                            "ALBUM" -> onAlbumClick(item.id)
                        }
                    },
                    onQueueClick = { item ->
                        playerManager.addToQueue(item)
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        val currentTrack = playerManager.currentTrack.value
        if (currentTrack != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF0F0F0))
                    .clickable { onExpandPlayer() }
            ) {
                MiniPlayer(
                    trackTitle = currentTrack.title,
                    streamUrl = "" 
                )
            }
        }
    }
}

@Composable
fun SectionView(
    section: SectionDto,
    onItemClick: (ItemDto) -> Unit,
    onQueueClick: (ItemDto) -> Unit
) {
    Column {
        Text(
            text = section.title, 
            style = MaterialTheme.typography.titleLarge, 
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(section.items) { item ->
                ItemCard(
                    item = item, 
                    onClick = { onItemClick(item) },
                    onQueueClick = { onQueueClick(item) }
                )
            }
        }
    }
}

@Composable
fun ItemCard(
    item: ItemDto,
    onClick: () -> Unit,
    onQueueClick: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(160.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = item.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .clip(if (item.type == "ARTIST") RoundedCornerShape(80.dp) else RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title, 
                    style = MaterialTheme.typography.bodyLarge, 
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
                Text(
                    text = item.subtitle, 
                    style = MaterialTheme.typography.bodySmall, 
                    color = Color.Gray,
                    maxLines = 1
                )
            }
            if (item.type == "TRACK") {
                Box {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert, 
                            contentDescription = "Opciones", 
                            tint = Color.Black, 
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false },
                        modifier = Modifier.background(Color.White)
                    ) {
                        DropdownMenuItem(
                            text = { Text("Añadir a la cola", color = Color.Black) },
                            onClick = {
                                onQueueClick()
                                showMenu = false
                            }
                        )
                    }
                }
            }
        }
    }
}
