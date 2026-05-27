package edu.udelp.music.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000f\u00c0\u0006\u0001"}, d2 = {"Ledu/udelp/music/data/remote/CatalogApi;", "", "getAlbumTracks", "", "Ledu/udelp/music/data/remote/dto/ItemDto;", "albumId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArtistTracks", "artistId", "getHomeContent", "Ledu/udelp/music/data/remote/dto/HomeContentDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "app_debug"})
public abstract interface CatalogApi {
    
    @retrofit2.http.GET(value = "api/v1/catalog/home")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHomeContent(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super edu.udelp.music.data.remote.dto.HomeContentDto> $completion);
    
    @retrofit2.http.GET(value = "api/v1/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.udelp.music.data.remote.dto.ItemDto>> $completion);
    
    @retrofit2.http.GET(value = "api/v1/artists/{id}/tracks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getArtistTracks(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String artistId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.udelp.music.data.remote.dto.ItemDto>> $completion);
    
    @retrofit2.http.GET(value = "api/v1/albums/{id}/tracks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlbumTracks(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String albumId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<edu.udelp.music.data.remote.dto.ItemDto>> $completion);
}