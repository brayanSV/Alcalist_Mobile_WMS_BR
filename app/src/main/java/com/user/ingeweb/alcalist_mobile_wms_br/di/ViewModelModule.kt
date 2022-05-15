package com.user.ingeweb.alcalist_mobile_wms_br.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.ingeweb.alcalist_mobile_wms_br.ui.task.TaskViewModel
import com.user.ingeweb.alcalist_mobile_wms_br.view_model.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    abstract fun bindTaskViewModel(taskViewModel: TaskViewModel): ViewModel

   /* @Binds
    @IntoMap
    @ViewModelKey(TeamsViewModel::class)
    abstract fun bindTeamsViewModell(teamsViewModel: TeamsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsTeamViewModel::class)
    abstract fun bindDetailsTeamViewModel(detailsTeamViewModel: DetailsTeamViewModel): ViewModel*/

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}