package learn.ebpearls.com.daggerdemo;

import dagger.Component;
import learn.ebpearls.com.daggerdemo.screens.HomeActivity;

/**
 * Created by Dell on 11/9/2017.
 */
@HomeActivityScope
@Component(modules = HomeActivityModule.class,dependencies = GitHubApplicationComponent.class)
public interface HomeActivityComponent {
    void injectHomeActivity(HomeActivity homeActivity);
}
