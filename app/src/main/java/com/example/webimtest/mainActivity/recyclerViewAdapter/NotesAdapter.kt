package com.example.webimtest.mainActivity.recyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webimtest.R
import com.example.webimtest.entities.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var notes = listOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

    class NotesViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bind(note: Note){
            view.title.text = note.title
        }
    }

}