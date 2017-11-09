package learn.ebpearls.com.daggerdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Nikesh on 11/9/2017.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GitHubApplicationScope {
}
