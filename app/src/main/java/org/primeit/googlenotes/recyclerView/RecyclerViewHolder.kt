package org.primeit.googlenotes.recyclerView


import android.view.View
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import org.primeit.googlenotes.R


class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public val titleTV = itemView.findViewById<TextView>(R.id.titleId)
    public val timeTv = itemView.findViewById<TextView>(R.id.timeId)
    public val deleteIV = itemView.findViewById<TextView>(R.id.deleteId)

}