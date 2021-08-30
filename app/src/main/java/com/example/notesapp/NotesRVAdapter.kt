package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_notes.view.*
import java.util.ArrayList


class NotesRVAdapter(val context: Context, val listner: MainActivity):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    val allNotes = ArrayList<Notes>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =
            NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes, parent, false))
        viewHolder.deleteButton.setOnClickListener {
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Notes>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()

    }

}
interface NotesRVAdapterI{
    fun onItemClicked(note:Notes)
}
