package com.example.android2jobapp.orm.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android2jobapp.orm.entity.ApplicationEntity

@Dao
interface ApplicationDAO {
    @Query("SELECT * FROM application")
    fun getAllApplications(): List<ApplicationEntity>

    @Query("SELECT * FROM application WHERE id = :id")
    fun getApplication(id: Int): ApplicationEntity?

    @Query("SELECT * FROM application WHERE jobid = :id")
    fun getApplicationForJobId(id: String): ApplicationEntity?

    @Insert
    fun insertApplication(vararg applications: ApplicationEntity)

    @Delete
    fun deleteApplication(application: ApplicationEntity)
}