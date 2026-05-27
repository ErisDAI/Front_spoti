package edu.udelp.music.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a,\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a8\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\u0015"}, d2 = {"HomeScreen", "", "content", "Ledu/udelp/music/data/remote/dto/HomeContentDto;", "onExpandPlayer", "Lkotlin/Function0;", "onArtistClick", "Lkotlin/Function1;", "", "onAlbumClick", "playerViewModel", "Ledu/udelp/music/ui/home/PlayerViewModel;", "ItemCard", "item", "Ledu/udelp/music/data/remote/dto/ItemDto;", "onClick", "onQueueClick", "SectionView", "section", "Ledu/udelp/music/data/remote/dto/SectionDto;", "onItemClick", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.dto.HomeContentDto content, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onExpandPlayer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onArtistClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAlbumClick, @org.jetbrains.annotations.NotNull()
    edu.udelp.music.ui.home.PlayerViewModel playerViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionView(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.dto.SectionDto section, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super edu.udelp.music.data.remote.dto.ItemDto, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super edu.udelp.music.data.remote.dto.ItemDto, kotlin.Unit> onQueueClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ItemCard(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.dto.ItemDto item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onQueueClick) {
    }
}