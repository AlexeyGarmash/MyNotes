package com.awashwinter.mynotes.usecases

import com.awashwinter.mynotes.base.NotesApp
import com.awashwinter.mynotes.repository.NotesRepository
import com.awashwinter.mynotes.room.entity.MyNote
import javax.inject.Inject

class UseCaseAddNote {

    @Inject
    lateinit var notesRepository: NotesRepository

    init {
        NotesApp.getInstance()?.appComponent?.injectRepository(this)
    }

    fun addNote(note: MyNote){
        notesRepository.insertNote(note)
    }
}