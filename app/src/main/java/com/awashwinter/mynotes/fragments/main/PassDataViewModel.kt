package com.awashwinter.mynotes.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awashwinter.mynotes.room.entity.MyNote

class PassDataViewModel: ViewModel() {

    private var liveDataNote : MutableLiveData<MyNote> = MutableLiveData()

    fun shareNote(note: MyNote){
        liveDataNote.value = note
    }

    fun getSharedNote() : LiveData<MyNote>{
        return liveDataNote
    }

}