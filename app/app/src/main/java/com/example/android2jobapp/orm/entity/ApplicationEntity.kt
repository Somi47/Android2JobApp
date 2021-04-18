package com.example.android2jobapp.orm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "application")
data class ApplicationEntity (
    @PrimaryKey(autoGenerate = true) var id: String,
    @ColumnInfo(name = "company")var company: String,
    @ColumnInfo(name = "description")var description: String,
    @ColumnInfo(name = "location")var location: String
)