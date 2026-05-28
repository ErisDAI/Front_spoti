package edu.udelp.music.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Ledu/udelp/music/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "api", "Ledu/udelp/music/data/remote/CatalogApi;", "(Ledu/udelp/music/data/remote/CatalogApi;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ledu/udelp/music/presentation/viewmodel/UiState;", "Ledu/udelp/music/data/remote/dto/HomeContentDto;", "getApi", "()Ledu/udelp/music/data/remote/CatalogApi;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadContent", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.udelp.music.data.remote.CatalogApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<edu.udelp.music.presentation.viewmodel.UiState<edu.udelp.music.data.remote.dto.HomeContentDto>> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<edu.udelp.music.presentation.viewmodel.UiState<edu.udelp.music.data.remote.dto.HomeContentDto>> uiState = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    edu.udelp.music.data.remote.CatalogApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final edu.udelp.music.data.remote.CatalogApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<edu.udelp.music.presentation.viewmodel.UiState<edu.udelp.music.data.remote.dto.HomeContentDto>> getUiState() {
        return null;
    }
    
    public final void loadContent() {
    }
}