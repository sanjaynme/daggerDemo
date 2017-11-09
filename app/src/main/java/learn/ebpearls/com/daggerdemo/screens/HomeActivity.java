package learn.ebpearls.com.daggerdemo.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import learn.ebpearls.com.daggerdemo.GitHubApplication;
import learn.ebpearls.com.daggerdemo.R;
import learn.ebpearls.com.daggerdemo.models.GithubRepo;
import learn.ebpearls.com.daggerdemo.network.GithubService;
import retrofit2.Call;

/**
 * Created by Nikesh on 11/9/2017.
 */

public class HomeActivity extends Activity {
    @BindView(R.id.repo_home_list)
    ListView listView;

    Call<List<GithubRepo>> reposCall;
    private GithubService githubService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }
}
