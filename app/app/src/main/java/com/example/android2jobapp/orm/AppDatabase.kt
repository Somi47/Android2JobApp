package com.example.android2jobapp.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android2jobapp.orm.dao.ApplicationDAO
import com.example.android2jobapp.orm.dao.JobDAO
import com.example.android2jobapp.orm.entity.ApplicationEntity
import com.example.android2jobapp.orm.entity.JobEntity


@Database(entities = [JobEntity::class, ApplicationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jobDao(): JobDAO
    abstract fun applicationDao(): ApplicationDAO
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "job_app.db").build()
            }
            return INSTANCE!!
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}