package com.awashwinter.mynotes.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awashwinter.mynotes.room.dao.MyNoteDao
import com.awashwinter.mynotes.room.entity.MyNote

@Database(entities = [MyNote::class], version = 1)
abstract class NotesRoomDatabase:RoomDatabase() {

    abstract fun getNotesDao(): MyNoteDao
}