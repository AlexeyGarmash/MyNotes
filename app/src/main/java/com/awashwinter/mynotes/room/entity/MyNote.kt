package com.awashwinter.mynotes.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class MyNote (

    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo(name = "body") var noteText: String = "",
    @ColumnInfo(name = "created_at") var createdAt: Long = 0,
    @ColumnInfo(name = "modified_at") var modifiedAt: Long = 0
)