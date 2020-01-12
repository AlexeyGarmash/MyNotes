package com.awashwinter.mynotes.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.awashwinter.mynotes.room.entity.MyNote
import com.awashwinter.mynotes.usecases.UseCaseAddNote
import com.awashwinter.mynotes.usecases.UseCaseGetNotes

class NotesMainViewModel: ViewModel() {

    private var useCaseNotesUpdates: UseCaseGetNotes = UseCaseGetNotes()


    private var note: MyNote = MyNote()

    fun getNotes(): LiveData<List<MyNote>>? {
        return useCaseNotesUpdates.getNotes()
    }


}