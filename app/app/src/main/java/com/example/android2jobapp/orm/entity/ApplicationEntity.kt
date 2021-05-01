package com.example.android2jobapp.orm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "application")
data class ApplicationEntity (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "email")var email: String,
    @ColumnInfo(name = "jobid")var jobid: String
)