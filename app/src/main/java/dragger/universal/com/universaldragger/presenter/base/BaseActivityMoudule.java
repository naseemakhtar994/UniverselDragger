package dragger.universal.com.universaldragger.presenter.base;

import android.app.Activity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import dagger.Module;
import dagger.Provides;

/**
 * Created by naseem on 2/2/18.
 */
@Module
public class BaseActivityMoudule {

    private final Activity splashActivity;

    public BaseActivityMoudule(Activity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @BaseActivityScope
    public Activity homeActivity() {
        return splashActivity;
    }

    @Provides
    @BaseActivityScope
    public ANRequest.PostRequestBuilder networking(){



        return  AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser");
    }


    @Provides
    @BaseActivityScope
    public ANRequest networkingRewuest(){


        return  networking().build();
    }

    @Provides
    @BaseActivityScope
    public String getResponse(){

       networkingRewuest().getAsString(new StringRequestListener() {
           @Override
           public void onResponse(String response) {
               return ;
           }

           @Override
           public void onError(ANError anError) {
               return;
           }
       });
return "";
    }




}
