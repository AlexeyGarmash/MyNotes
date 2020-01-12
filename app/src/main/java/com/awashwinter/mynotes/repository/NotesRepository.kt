package com.awashwinter.mynotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.awashwinter.mynotes.base.NotesApp
import com.awashwinter.mynotes.room.dao.MyNoteDao
import com.awashwinter.mynotes.room.entity.MyNote
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NotesRepository {

    private val noteDao: MyNoteDao? = NotesApp.getInstance()?.database?.getNotesDao()

    var mutableStateDb = MutableLiveData<StateDb>()

    fun getNotes(): LiveData<List<MyNote>>? {
        return noteDao?.getNotes()
    }


    fun insertNote(note: MyNote){
        mutableStateDb.value = StateDb.START
        Completable.fromAction {
            noteDao?.insertWithTimestamp(note)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {mutableStateDb.value = StateDb.ERROR},
                onComplete = {mutableStateDb.value = StateDb.FINISH}
            )
    }

}