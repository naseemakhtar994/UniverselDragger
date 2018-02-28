package dragger.universal.com.universaldragger.di.component;

import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import dagger.Component;
import dragger.universal.com.universaldragger.di.ActivityModule;
import dragger.universal.com.universaldragger.di.GithubApplicationScope;
import dragger.universal.com.universaldragger.di.PicassoModule;
import dragger.universal.com.universaldragger.di.ServiceModule;
import dragger.universal.com.universaldragger.network.GithubService;

@GithubApplicationScope
@Component(modules = {ServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface ApplicationComponent {

    Picasso getPicasso();

    ProgressBar getprogressBar();

    GithubService getGithubService();



}
