package edu.udelp.music.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.udelp.music.data.remote.dto.ItemDto
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import edu.udelp.music.player.MusicPlayerManager
import edu.udelp.music.ui.home.PlayerViewModel

@Composable
fun SearchScreen(
    onItemClick: (ItemDto) -> Unit,
    searchViewModel: SearchViewModel = hiltViewModel(),
    playerViewModel: PlayerViewModel = hiltViewModel()
) {
    val state = searchViewModel.state.value
    val playerManager = playerViewModel.playerManager

    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp)) {
        TextField(
            value = state.query,
            onValueChange = { searchViewModel.onQueryChange(it) },
            label = { Text("Buscar canciones, artistas...") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF0F0F0),
                unfocusedContainerColor = Color(0xFFF0F0F0)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        if (state.isLoading) {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }

        LazyColumn {
            items(state.results) { item ->
                ListItem(
                    headlineContent = { Text(item.title, color = Color.Black) },
                    supportingContent = { Text(item.subtitle, color = Color.Gray) },
                    colors = ListItemDefaults.colors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { 
                            if (item.type == "TRACK") {
                                playerManager.playTrack(item)
                            }
                            onItemClick(item) 
                        }
                )
            }
        }
    }
}
