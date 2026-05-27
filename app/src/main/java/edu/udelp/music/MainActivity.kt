package edu.udelp.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import edu.udelp.music.ui.auth.LoginScreen
import edu.udelp.music.ui.auth.RegisterScreen
import edu.udelp.music.ui.home.HomeScreen
import edu.udelp.music.ui.home.HomeViewModel
import edu.udelp.music.ui.home.PlayerViewModel
import edu.udelp.music.ui.home.FullPlayerScreen
import edu.udelp.music.ui.home.ArtistTracksScreen
import edu.udelp.music.ui.home.AlbumTracksScreen
import edu.udelp.music.ui.search.SearchScreen
import edu.udelp.music.ui.account.AccountScreen
import edu.udelp.music.ui.LanguageManager
import edu.udelp.music.player.MusicPlayerManager
import androidx.hilt.navigation.compose.hiltViewModel
import javax.inject.Inject
import edu.udelp.music.data.remote.dto.HomeContentDto
import edu.udelp.music.data.remote.dto.ItemDto

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var playerManager: MusicPlayerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageManager.applySystemLocale(this)

        setContent {
            MaterialTheme {
                var currentScreen by remember { mutableStateOf("login") }
                var isPlayerExpanded by remember { mutableStateOf(false) }
                var selectedArtistId by remember { mutableStateOf<String?>(null) }
                var selectedAlbumId by remember { mutableStateOf<String?>(null) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        when {
                            currentScreen == "login" -> LoginScreen(
                                onLoginSuccess = { currentScreen = "home" },
                                onNavigateToRegister = { currentScreen = "register" }
                            )
                            currentScreen == "register" -> RegisterScreen(
                                onRegisterSuccess = { currentScreen = "login" },
                                onBackToLogin = { currentScreen = "login" }
                            )
                            selectedArtistId != null -> {
                                ArtistTracksScreen(
                                    artistId = selectedArtistId!!,
                                    onBack = { selectedArtistId = null }
                                )
                            }
                            selectedAlbumId != null -> {
                                AlbumTracksScreen(
                                    albumId = selectedAlbumId!!,
                                    onBack = { selectedAlbumId = null }
                                )
                            }
                            else -> {
                                MainScaffold(
                                    currentScreen = currentScreen,
                                    onNavigate = { currentScreen = it },
                                    onExpandPlayer = { isPlayerExpanded = true },
                                    onArtistClick = { id -> selectedArtistId = id },
                                    onAlbumClick = { id -> selectedAlbumId = id }
                                )
                            }
                        }

                        if (isPlayerExpanded) {
                            FullPlayerScreen(
                                playerManager = playerManager,
                                onCollapse = { isPlayerExpanded = false }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScaffold(
    currentScreen: String,
    onNavigate: (String) -> Unit,
    onExpandPlayer: () -> Unit,
    onArtistClick: (String) -> Unit,
    onAlbumClick: (String) -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = currentScreen == "home",
                    onClick = { onNavigate("home") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color(0xFFF0F0F0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = currentScreen == "search",
                    onClick = { onNavigate("search") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color(0xFFF0F0F0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Account") },
                    label = { Text("Account") },
                    selected = currentScreen == "account",
                    onClick = { onNavigate("account") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color(0xFFF0F0F0)
                    )
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (currentScreen) {
                "home" -> {
                    val viewModel: HomeViewModel = hiltViewModel()
                    val state = viewModel.state.value
                    
                    if (state.isLoading) {
                        Box(Modifier.fillMaxSize()) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center), color = Color.Black)
                        }
                    } else if (state.content != null) {
                        HomeScreen(
                            state.content!!, 
                            onExpandPlayer = onExpandPlayer,
                            onArtistClick = onArtistClick,
                            onAlbumClick = onAlbumClick
                        )
                    }
                }
                "search" -> {
                    SearchScreen(onItemClick = { /* Manejado por el player global */ })
                }
                "account" -> {
                    AccountScreen()
                }
            }
        }
    }
}
