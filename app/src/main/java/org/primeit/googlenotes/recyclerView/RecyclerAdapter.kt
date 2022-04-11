package org.primeit.googlenotes.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.primeit.googlenotes.R
import org.primeit.googlenotes.data.model.Note
import org.primeit.googlenotes.listeners.NoteListeners

class RecyclerAdapter(
    val context: Context,
    val listeners: NoteListeners
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val userList = ArrayList<Note>()
    lateinit var noteListeners: NoteListeners


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.note_itemview, parent, false)
        return RecyclerViewHolder(itemView)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.titleTV.setText(userList.get(position).noteTitle)

        holder.timeTv.setText("Last Updated : " + userList.get(position).timeStamp)

        holder.deleteIV.setOnClickListener {
            noteListeners.ondDeleteNote(userList.get(position))

        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateList(newList: List<Note>) {
        userList.clear()
        userList.addAll(newList)
        notifyDataSetChanged()


    }


}