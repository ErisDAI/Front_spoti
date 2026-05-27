package edu.udelp.music.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import edu.udelp.music.player.MusicPlayerManager

@Composable
fun FullPlayerScreen(
    playerManager: MusicPlayerManager,
    onCollapse: () -> Unit
) {
    val track = playerManager.currentTrack.value ?: return
    val isPlaying = playerManager.isPlaying.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco por petición del usuario
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onCollapse, modifier = Modifier.align(Alignment.Start)) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown, 
                    contentDescription = "Collapse", 
                    tint = Color.Black, 
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                AsyncImage(
                    model = track.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            
            Spacer(modifier = Modifier.height(60.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(), 
                horizontalArrangement = Arrangement.SpaceBetween, 
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = track.title, 
                        style = MaterialTheme.typography.headlineSmall, 
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = track.subtitle, 
                        style = MaterialTheme.typography.bodyLarge, 
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                }
                Icon(
                    imageVector = Icons.Default.FavoriteBorder, 
                    contentDescription = null, 
                    tint = Color.Black, 
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(30.dp))
            
            Slider(
                value = 0.3f, 
                onValueChange = {},
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Black,
                    inactiveTrackColor = Color.LightGray
                )
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("0:45", color = Color.Gray, fontSize = 12.sp)
                Text("3:20", color = Color.Gray, fontSize = 12.sp)
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) { 
                    Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.Black, modifier = Modifier.size(32.dp)) 
                }
                
                IconButton(onClick = { playerManager.skipPrevious() }) { 
                    Icon(Icons.Default.SkipPrevious, contentDescription = null, tint = Color.Black, modifier = Modifier.size(48.dp)) 
                }
                
                FloatingActionButton(
                    onClick = { playerManager.togglePlayPause() },
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    shape = androidx.compose.foundation.shape.CircleShape,
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }

                IconButton(onClick = { playerManager.skipNext() }) { 
                    Icon(Icons.Default.SkipNext, contentDescription = null, tint = Color.Black, modifier = Modifier.size(48.dp)) 
                }
                
                IconButton(onClick = {}) { 
                    Icon(Icons.Default.List, contentDescription = null, tint = Color.Black, modifier = Modifier.size(32.dp)) 
                }
            }
        }
    }
}
