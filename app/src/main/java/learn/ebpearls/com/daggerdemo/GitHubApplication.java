package learn.ebpearls.com.daggerdemo;

import android.app.Activity;
import android.app.Application;

import com.squareup.picasso.Picasso;

import learn.ebpearls.com.daggerdemo.network.GithubService;
import timber.log.Timber;

/**
 * Created by Nikesh on 11/9/2017.
 */

public class GitHubApplication extends Application {
    //   Activity

    //GithubService   picasso

    //retrofit    OkHttp3Downloader

    //gson      okhttp

    //      logger    cache

    //      timber           file

    GithubService gitHubService;
    Picasso picasso;
    private GitHubApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        //include only constructor argument
        component = DaggerGitHubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        gitHubService = component.getGitHubService();
        picasso = component.getPicasso();
    }

    public static GitHubApplication get(Activity activity) {
        return (GitHubApplication) activity.getApplication();
    }

    public GithubService getGitHubService() {
        return gitHubService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
