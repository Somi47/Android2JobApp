package com.example.android2jobapp.orm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job")
data class JobEntity (
        @PrimaryKey(autoGenerate = true) var id: String,
        @ColumnInfo(name = "email")var email: String,
        @ColumnInfo(name = "jobid")var jobid: String
)