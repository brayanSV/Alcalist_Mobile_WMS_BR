package com.user.ingeweb.alcalist_mobile_wms_br.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.user.ingeweb.alcalist_mobile_wms_br.model.Task

@Database(
    entities = [
        Task::class
    ],
    version = 1
)

abstract class Alcalist_WMS_Db: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}