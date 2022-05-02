package com.user.ingeweb.alcalist_mobile_wms_br.di

import android.app.Application
import com.user.ingeweb.alcalist_mobile_wms_br.MiApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(miApp: MiApp)
}