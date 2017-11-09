package learn.ebpearls.com.daggerdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;
import learn.ebpearls.com.daggerdemo.network.GithubService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nikesh on 11/9/2017.
 */
@Module(includes = NetworkModule.class)
public class GitHubServiceModule {
    @Provides
    @GitHubApplicationScope
    public GithubService gitHubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

    @Provides
    @GitHubApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    @GitHubApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }
}
