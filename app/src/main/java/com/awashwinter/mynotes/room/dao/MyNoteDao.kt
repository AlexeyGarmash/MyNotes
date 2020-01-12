package com.awashwinter.mynotes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.awashwinter.mynotes.room.RoomQueries
import com.awashwinter.mynotes.room.entity.MyNote
import io.reactivex.Flowable

@Dao
abstract class MyNoteDao {


    @Query("SELECT * FROM notes ORDER BY modified_at DESC")
    abstract fun getNotes():LiveData<List<MyNote>>

    @Query("SELECT * FROM notes ORDER BY modified_at ASC")
    abstract fun getNotesDateAsc():LiveData<List<MyNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(note: MyNote)

    @Update
    abstract fun update(note: MyNote)

    fun insertWithTimestamp(note: MyNote) {
        insert(note.apply{
            createdAt = System.currentTimeMillis()
            modifiedAt = System.currentTimeMillis()
        })
    }

    fun updateWithTimestamp(note: MyNote){
        update(note.apply {
            modifiedAt = System.currentTimeMillis()
        })
    }




}