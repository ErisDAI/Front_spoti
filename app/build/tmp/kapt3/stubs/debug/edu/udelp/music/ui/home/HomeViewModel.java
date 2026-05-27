package edu.udelp.music.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ledu/udelp/music/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "api", "Ledu/udelp/music/data/remote/CatalogApi;", "(Ledu/udelp/music/data/remote/CatalogApi;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Ledu/udelp/music/ui/home/HomeState;", "getApi", "()Ledu/udelp/music/data/remote/CatalogApi;", "state", "Landroidx/compose/runtime/State;", "getState", "()Landroidx/compose/runtime/State;", "loadContent", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final edu.udelp.music.data.remote.CatalogApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<edu.udelp.music.ui.home.HomeState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<edu.udelp.music.ui.home.HomeState> state = null;
    
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
    public final androidx.compose.runtime.State<edu.udelp.music.ui.home.HomeState> getState() {
        return null;
    }
    
    private final void loadContent() {
    }
}