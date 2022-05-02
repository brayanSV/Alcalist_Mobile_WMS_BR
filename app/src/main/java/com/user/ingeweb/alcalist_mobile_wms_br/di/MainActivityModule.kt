package com.user.ingeweb.alcalist_mobile_wms_br.di

import com.user.ingeweb.alcalist_mobile_wms_br.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

