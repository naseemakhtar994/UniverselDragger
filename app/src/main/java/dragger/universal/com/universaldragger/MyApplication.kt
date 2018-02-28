package dragger.universal.com.universaldragger

import android.app.Activity
import android.app.Application
import dragger.universal.com.universaldragger.di.ContextModule
import dragger.universal.com.universaldragger.di.component.ApplicationComponent
import dragger.universal.com.universaldragger.di.component.DaggerApplicationComponent
import timber.log.Timber

/**
 * Created by naseem on 28/2/18.
 */

class MyApplication : Application() {

    lateinit var component: ApplicationComponent



    //   Activity

    //GithubService   picasso

    //retrofit    OkHttp3Downloader

    //gson      okhttp

    //      logger    cache

    //      timber           file

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        component = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()


    }

    fun component(): ApplicationComponent? {
        return component
    }

    companion object {

        operator fun get(activity: Activity): MyApplication {
            return activity.application as MyApplication
        }
    }
}
