package learn.ebpearls.com.daggerdemo;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nikesh on 11/9/2017.
 */
@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @GitHubApplicationScope
    @Named("activity_context")
    public Context context() {
        return context;
    }
}
