package com.awashwinter.mynotes.fragments.edit

import androidx.lifecycle.ViewModel
import com.awashwinter.mynotes.room.entity.MyNote
import com.awashwinter.mynotes.usecases.UseCaseAddNote

class NoteEditViewModel: ViewModel() {

    private var editMode: Boolean = false

    private lateinit var passedNote: MyNote
    private var useCaseNotesAdd: UseCaseAddNote = UseCaseAddNote()

    fun setEditMode(edit: Boolean){
        editMode = edit
    }

    fun setNote(note: MyNote) {
        passedNote = note
    }

    fun createOrUpdateNote(text: String){
        when(editMode){
            true -> updateNote(text)
            false -> addNote(text)
        }
    }

    private fun addNote(text: String) {
        var tempNote = MyNote()
        tempNote.apply { noteText = text }
        useCaseNotesAdd.addNote(tempNote)
    }

    private fun updateNote(text: String){
        passedNote!!.apply { noteText = text }
        useCaseNotesAdd.updateNote(passedNote)
    }
}