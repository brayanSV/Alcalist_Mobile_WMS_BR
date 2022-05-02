package com.user.ingeweb.alcalist_mobile_wms_br

import android.app.Activity
import android.app.Application
import com.user.ingeweb.alcalist_mobile_wms_br.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MiApp: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}