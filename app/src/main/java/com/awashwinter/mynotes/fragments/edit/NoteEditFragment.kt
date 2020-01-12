package com.awashwinter.mynotes.fragments.edit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.awashwinter.mynotes.R
import com.awashwinter.mynotes.fragments.main.PassDataViewModel
import kotlinx.android.synthetic.main.fragment_note_edit.*

/**
 * A simple [Fragment] subclass.
 */
class NoteEditFragment : Fragment() {

    private lateinit var passDataViewModel: PassDataViewModel
    private lateinit var noteEditViewModel: NoteEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_edit, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        passDataViewModel = ViewModelProviders.of(activity!!).get(PassDataViewModel::class.java)
        noteEditViewModel = ViewModelProviders.of(this).get(NoteEditViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabCreateEdit.setOnClickListener {
            noteEditViewModel.createOrUpdateNote(tvNoteText.text.toString())
            Navigation.findNavController(tvNoteText).navigateUp()
        }

        passDataViewModel.getSharedNote().observe(this, Observer {
            noteEditViewModel.setNote(it)
            tvNoteText.setText(it.noteText)
        })
    }


    override fun onResume() {
        super.onResume()
        noteEditViewModel.setEditMode(arguments!!.getBoolean("editMode"))
    }


}
