package com.user.ingeweb.alcalist_mobile_wms_br.di

import android.app.Application
import androidx.room.Room
import com.user.ingeweb.alcalist_mobile_wms_br.api.ApplicationApi
import com.user.ingeweb.alcalist_mobile_wms_br.caseuses.CustomGsonConverterFactory
import com.user.ingeweb.alcalist_mobile_wms_br.db.Alcalist_WMS_Db
import com.user.ingeweb.alcalist_mobile_wms_br.db.TaskDao
import com.user.ingeweb.alcalist_mobile_wms_br.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideApplicationApi(): ApplicationApi {
        return Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(CustomGsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(ApplicationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): Alcalist_WMS_Db {
        return Room.databaseBuilder(app, Alcalist_WMS_Db::class.java, "Alcalist_WMS.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideTeamsDao(db: Alcalist_WMS_Db): TaskDao {
        return db.taskDao()
    }
}