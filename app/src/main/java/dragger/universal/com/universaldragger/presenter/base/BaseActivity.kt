package com.parkingsystemnypd.presenter.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.afollestad.materialdialogs.DialogAction
import com.afollestad.materialdialogs.MaterialDialog
import com.livinglifetechway.k4kotlin.hide
import com.livinglifetechway.k4kotlin.show
import dragger.universal.com.universaldragger.MyApplication
import dragger.universal.com.universaldragger.R
import dragger.universal.com.universaldragger.presenter.base.BaseActivityMoudule
import dragger.universal.com.universaldragger.presenter.base.DaggerBaseActivityComponent
import javax.inject.Inject


/**
 * Created by naseem on 31/1/18.
 */

open class BaseActivity(var layout:Int) : AppCompatActivity(){

   /* @Inject
    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var myAdapter: MyAdapter
*/
    val component : DaggerBaseActivityComponent by lazy { getdrager() }


    /*
    * make progres bar universal
    * */
    @Inject
    lateinit var progressBar: ProgressBar


    fun getdrager():DaggerBaseActivityComponent{

        return  DaggerBaseActivityComponent.builder()
                .baseActivityMoudule(BaseActivityMoudule(this))

                .applicationComponent(MyApplication.get(this).component())
                .build() as DaggerBaseActivityComponent

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        getdrager().injectBaseActivity(this)


    }

    /*show progressbar*/
    fun showProgressBar(){

        progressBar.show()
    }


/*
* hide progressBar
* */
    fun hideProgressBar(){

        progressBar.hide()
    }


    fun showMessageDialogFinishActivity(string: String){


        MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(string)
                .positiveText("Ok")
                .onPositive(MaterialDialog.SingleButtonCallback({ materialDialog: MaterialDialog, dialogAction: DialogAction ->

                    finish()

                }))


                .show()

    }


    fun showMessageDialog(string: String){


        MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(string)
                .positiveText("ok")

                .show()

    }

}
