package dragger.universal.com.universaldragger.presenter.base;

import com.androidnetworking.common.ANRequest;

import com.parkingsystemnypd.presenter.base.BaseActivity;


import dagger.Component;
import dragger.universal.com.universaldragger.MainActivity;
import dragger.universal.com.universaldragger.di.component.ApplicationComponent;

@BaseActivityScope
@Component(modules = BaseActivityMoudule.class, dependencies = ApplicationComponent.class)
public interface BaseActivityComponent {

    void injectSplashActivity(MainActivity homeActivity);

 void injectBaseActivity(BaseActivity homeActivity);


 void injectLoginActivity(BaseActivity homeActivity);


    ANRequest.PostRequestBuilder getREwuest();

    ANRequest getANR();

    String getresponse();



   // void setReq(ANRequest anRequest, final onResponse onResponse);


}
