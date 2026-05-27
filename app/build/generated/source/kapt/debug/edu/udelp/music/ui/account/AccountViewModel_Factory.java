package edu.udelp.music.ui.account;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.udelp.music.data.remote.AuthApi;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AccountViewModel_Factory implements Factory<AccountViewModel> {
  private final Provider<AuthApi> apiProvider;

  public AccountViewModel_Factory(Provider<AuthApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public AccountViewModel get() {
    return newInstance(apiProvider.get());
  }

  public static AccountViewModel_Factory create(Provider<AuthApi> apiProvider) {
    return new AccountViewModel_Factory(apiProvider);
  }

  public static AccountViewModel newInstance(AuthApi api) {
    return new AccountViewModel(api);
  }
}
