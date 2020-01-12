package com.awashwinter.mynotes.usecases

import androidx.lifecycle.LiveData
import com.awashwinter.mynotes.base.NotesApp
import com.awashwinter.mynotes.repository.NotesRepository
import com.awashwinter.mynotes.room.dao.MyNoteDao
import com.awashwinter.mynotes.room.entity.MyNote
import javax.inject.Inject

class UseCaseGetNotes {

    @Inject
    lateinit var notesRepository: NotesRepository

    init {
        NotesApp.getInstance()?.appComponent?.injectRepository(this)
    }

    fun getNotes(): LiveData<List<MyNote>>? {
        return notesRepository.getNotes()
    }
}