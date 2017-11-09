package learn.ebpearls.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import learn.ebpearls.com.daggerdemo.screens.HomeActivity;

/**
 * Created by Dell on 11/9/2017.
 */

@Module
public class HomeActivityModule {
    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public HomeActivity homeActivity() {
        return homeActivity;
    }
}
