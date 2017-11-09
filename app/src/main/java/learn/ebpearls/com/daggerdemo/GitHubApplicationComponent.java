package learn.ebpearls.com.daggerdemo;

import com.squareup.picasso.Picasso;

import dagger.Component;
import learn.ebpearls.com.daggerdemo.network.GithubService;

/**
 * Created by Nikesh on 11/9/2017.
 */
@GitHubApplicationScope
@Component(modules = {GitHubServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface GitHubApplicationComponent {
    GithubService getGitHubService();

    Picasso getPicasso();
}
