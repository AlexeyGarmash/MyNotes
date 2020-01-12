package com.awashwinter.mynotes.base

import android.app.Application
import androidx.room.Room
import com.awashwinter.mynotes.di.AppComponent
import com.awashwinter.mynotes.di.DaggerAppComponent
import com.awashwinter.mynotes.room.database.NotesRoomDatabase

class NotesApp: Application() {

    companion object{
        @Volatile
        private lateinit var INSTANCE: NotesApp

        fun getInstance(): NotesApp? {
            return INSTANCE
        }
    }

    var database: NotesRoomDatabase? = null

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        database = Room.databaseBuilder(applicationContext, NotesRoomDatabase::class.java, "database").build()
        appComponent = DaggerAppComponent.create()
    }
}