package com.example.android2jobapp.orm.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android2jobapp.orm.entity.JobEntity

@Dao
interface JobDAO {
    @Query("SELECT * FROM job")
    fun getAllJobs(): List<JobEntity>

    @Query("SELECT * FROM job WHERE id = :id")
    fun getJob(id: String): JobEntity
}