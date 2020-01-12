package com.awashwinter.mynotes.fragments.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DiffUtil
import com.awashwinter.mynotes.R
import com.awashwinter.mynotes.adapters.MainAdapter
import com.awashwinter.mynotes.adapters.NoteDiffUtilCallback
import com.awashwinter.mynotes.room.entity.MyNote
import kotlinx.android.synthetic.main.fragment_notes.*

/**
 * A simple [Fragment] subclass.
 */
class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesMainViewModel
    private lateinit var passDataViewModel: PassDataViewModel

    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesViewModel = ViewModelProviders.of(this).get(NotesMainViewModel::class.java)
        passDataViewModel = ViewModelProviders.of(activity!!).get(PassDataViewModel::class.java)
        adapter = MainAdapter(clickListener = {myNote, i ->
            run {
                passDataViewModel.shareNote(myNote)
                navigateToEdit(true)
            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNotes.adapter = adapter
        fabAdd.setOnClickListener {
            //notesViewModel.addNote("test wre")
            navigateToEdit(false)
        }
        notesViewModel.getNotes()?.observe(viewLifecycleOwner, Observer {
            applyChanges(it)
        })
    }

    private fun navigateToEdit(edit: Boolean){
        var bundle: Bundle = Bundle()
        bundle.putBoolean("editMode",edit)
        NavHostFragment.findNavController(this).navigate(R.id.action_notesFragment_to_noteEditFragment, bundle)
    }

    private fun applyChanges(it: List<MyNote>?) {
        val mutList: ArrayList<MyNote> = ArrayList(it)
        val noteDiffUtilCallback = NoteDiffUtilCallback(adapter.listNotes, mutList)
        val noteDiffResult = DiffUtil.calculateDiff(noteDiffUtilCallback)
        adapter.setItems(mutList)
        noteDiffResult.dispatchUpdatesTo(adapter)
    }
}
