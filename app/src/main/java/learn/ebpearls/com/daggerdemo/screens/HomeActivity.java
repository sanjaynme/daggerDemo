package learn.ebpearls.com.daggerdemo.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import learn.ebpearls.com.daggerdemo.GitHubApplication;
import learn.ebpearls.com.daggerdemo.R;
import learn.ebpearls.com.daggerdemo.models.GithubRepo;
import learn.ebpearls.com.daggerdemo.network.GithubService;
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
    GithubService githubService;
    Picasso picasso;
    AdapterRepos adapterRepos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        githubService = GitHubApplication.get(this).getGitHubService();
        picasso = GitHubApplication.get(this).getPicasso();
        adapterRepos = new AdapterRepos(this, picasso);
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
}
