package com.cuncis.roomlivedatakotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuncis.roomlivedatakotlin.R
import com.cuncis.roomlivedatakotlin.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(private var context: Context): RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    private var noteList: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.tvTitle.text = noteList[position].title
        holder.tvDescription.text = noteList[position].description
    }

    fun setNoteList(noteList: List<Note>) {
        this.noteList = noteList
        notifyDataSetChanged()
    }

    inner class NoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.text_view_title
        var tvDescription: TextView = itemView.text_view_description
    }
}
