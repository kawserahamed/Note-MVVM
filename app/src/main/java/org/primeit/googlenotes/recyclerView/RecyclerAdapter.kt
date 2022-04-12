package org.primeit.googlenotes.recyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.primeit.googlenotes.R
import org.primeit.googlenotes.data.model.Note
import org.primeit.googlenotes.listeners.NoteListeners

class RecyclerAdapter(val listeners: NoteListeners) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var userlist: ArrayList<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.note_itemview, parent, false)
        return MyViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.titleTV.text = userlist[position].noteTitle
        holder.timeTv.text = "Last Updated : " + userlist[position].timeStamp

        holder.deleteIV.setOnClickListener {
            listeners.ondDeleteNote(userlist[position])
        }

        holder.itemView.setOnClickListener {

            listeners.onClickedNote(userlist[position])
        }

    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Note>) {
        userlist.clear()
        userlist.addAll(newList)
        notifyDataSetChanged()


    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTV = itemView.findViewById<TextView>(R.id.titleId)
        val timeTv = itemView.findViewById<TextView>(R.id.timeId)
        val deleteIV = itemView.findViewById<ImageView>(R.id.deleteId)

    }

}


