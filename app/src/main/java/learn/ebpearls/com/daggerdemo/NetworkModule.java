package learn.ebpearls.com.daggerdemo;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Nikesh on 11/9/2017.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {
    @Provides
    @GitHubApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
    }

    @Provides
    @GitHubApplicationScope

    public File cacheFile(@ApplicationContext
                                  Context context) {
        return new File(context.getCacheDir(), "okhttp.cache");
//        cacheFile.mkdirs();

    }

    @Provides
    @GitHubApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);//10MB cache

    }

    @Provides
    @GitHubApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }
}
