package edu.udelp.music.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Connection
import java.sql.DriverManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class H2DatabaseManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val dbPath = "${context.filesDir.absolutePath}/udelp_local_db"
    private val url = "jdbc:h2:$dbPath;FILE_LOCK=FS;PAGE_SIZE=1024;CACHE_SIZE=8192"

    init {
        // Inicializar la tabla en un hilo de background para no romper el Main Thread
        CoroutineScope(Dispatchers.IO).launch {
            try {
                execute { connection ->
                    val sql = """
                        CREATE TABLE IF NOT EXISTS offline_tracks (
                            id VARCHAR(255) PRIMARY KEY,
                            title VARCHAR(255),
                            artist VARCHAR(255),
                            local_path VARCHAR(255),
                            image_url VARCHAR(255)
                        )
                    """.trimIndent()
                    connection.createStatement().execute(sql)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getConnection(): Connection {
        Class.forName("org.h2.Driver")
        return DriverManager.getConnection(url, "sa", "")
    }

    fun execute(action: (Connection) -> Unit) {
        try {
            val connection = getConnection()
            action(connection)
            connection.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
