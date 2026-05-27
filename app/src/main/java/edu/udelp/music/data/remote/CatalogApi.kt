package edu.udelp.music.data.remote

import edu.udelp.music.data.remote.dto.HomeContentDto
import edu.udelp.music.data.remote.dto.ItemDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogApi {
    @GET("api/v1/catalog/home")
    suspend fun getHomeContent(): HomeContentDto

    @GET("api/v1/search")
    suspend fun search(@Query("q") query: String): List<ItemDto>

    @GET("api/v1/artists/{id}/tracks")
    suspend fun getArtistTracks(@Path("id") artistId: String): List<ItemDto>

    @GET("api/v1/albums/{id}/tracks")
    suspend fun getAlbumTracks(@Path("id") albumId: String): List<ItemDto>
}
