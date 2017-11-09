package learn.ebpearls.com.daggerdemo.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import learn.ebpearls.com.daggerdemo.DaggerHomeActivityComponent;
import learn.ebpearls.com.daggerdemo.GitHubApplication;
import learn.ebpearls.com.daggerdemo.HomeActivityComponent;
import learn.ebpearls.com.daggerdemo.HomeActivityModule;
import learn.ebpearls.com.daggerdemo.R;
import learn.ebpearls.com.daggerdemo.models.GithubRepo;
import learn.ebpearls.com.daggerdemo.network.GithubService;
import learn.ebpearls.com.daggerdemo.screens.home.AdapterRepos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nikesh on 11/9/2017.
 */

public class HomeActivity extends Activity {
    @BindView(R.id.repo_home_list)
    ListView listView;

    Call<List<GithubRepo>> reposCall;
    @Inject
    GithubService githubService;
    @Inject
    AdapterRepos adapterRepos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        HomeActivityComponent homeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .gitHubApplicationComponent(GitHubApplication.get(this).getComponent())
                .build();


        homeActivityComponent.injectHomeActivity(this);

        listView.setAdapter(adapterRepos);

        reposCall = githubService.getAllRepos();

        reposCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                adapterRepos.swapdata(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reposCall != null) {
            reposCall.cancel();
        }
    }
}
