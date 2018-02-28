package dragger.universal.com.universaldragger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.parkingsystemnypd.presenter.base.BaseActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main), ParsedRequestListener<Any> {
    override fun onResponse(response: Any?) {
/*
* show responseBody
* */
    }

    override fun onError(anError: ANError?) {
        Log.e("", "")
/*
* show Error Body
* */
    }



    @Inject
    lateinit var myAdapter: Adapter

    fun callapi1(value: String) {


        component.rEwuest.addBodyParameter(value, "")


        // component.setReq(component.rEwuest.build(),this)

        component.rEwuest.build().getAsObject(Any::class.java, this);

    }

    override fun onResume() {
        super.onResume()
showProgressBar()
        component.injectSplashActivity(this)
        callapi1("1")


        async(UI) {
            Thread.sleep(2000)
hideProgressBar()
           // startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
    }
    /* override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         setContentView(R.layout.dummy_recy)
         //applicationInjector



        // progressBar!!.hide()

     }*/
}
