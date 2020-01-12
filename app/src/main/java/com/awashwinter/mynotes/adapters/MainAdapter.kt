package com.awashwinter.mynotes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awashwinter.mynotes.R
import com.awashwinter.mynotes.room.entity.MyNote
import kotlinx.android.synthetic.main.note_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter : RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {


    fun Long.timestampToString(dateFormat: String): String {
        val simpleDateFormat: SimpleDateFormat = SimpleDateFormat()
        val calendar: Calendar = Calendar.getInstance()

        calendar.timeInMillis = this
        return simpleDateFormat.format(calendar.time)
    }

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(note: MyNote) {
            with(itemView) {
                tvTextBody.text = note.noteText
                tvTimestamp.text = note.createdAt.timestampToString("dd/MM/yyyy hh:mm:ss")
            }
        }
    }

    var listNotes: ArrayList<MyNote> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun getItemCount() = listNotes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }

    fun setItems(newItems: ArrayList<MyNote>) {
        listNotes.clear()
        listNotes.addAll(newItems)
    }
}