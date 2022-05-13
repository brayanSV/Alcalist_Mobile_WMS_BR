package com.user.ingeweb.alcalist_mobile_wms_br.di

import com.user.ingeweb.alcalist_mobile_wms_br.ui.task.TaskFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeTaskFragment(): TaskFragment

    /*@ContributesAndroidInjector
    abstract fun contributeTeamsFragment(): TeamsFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailsTeamsFragment(): DetailsTeamFragment*/
}