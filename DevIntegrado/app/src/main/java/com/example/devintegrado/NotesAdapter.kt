package com.example.devintegrado

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devintegrado.database.NotesDatabaseHelper.Companion.DESCRIPTION_NOTES
import com.example.devintegrado.database.NotesDatabaseHelper.Companion.TITLE_NOTES

class NotesAdapter(private val listener: NoteClickedListener):RecyclerView.Adapter<NotesNewHolder>() {

    private var mCursor: Cursor? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesNewHolder =
        NotesNewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun onBindViewHolder(holder: NotesNewHolder, position: Int) {
        mCursor?.moveToPosition(position)

        holder.noteTitle.text = mCursor?.getString(mCursor?.getColumnIndex(TITLE_NOTES) as Int)
        holder.noteDescripton.text = mCursor?.getString(mCursor?.getColumnIndex(DESCRIPTION_NOTES) as Int)
        holder.noteBottomRemove.setOnClickListener{
            mCursor?.moveToPosition(position)
            listener.noteRemoveItem(mCursor)
            notifyDataSetChanged()
        }
        holder.itemView.setOnClickListener{listener.noteClickedItem(mCursor as Cursor)}
    }

    override fun getItemCount(): Int = if (mCursor != null) mCursor?.count as Int else 0

    fun setCursor(newCursor: Cursor?){
        mCursor=newCursor
        notifyDataSetChanged()
    }
}

class NotesNewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val noteTitle = itemView.findViewById(R.id.note_title) as TextView
    val noteDescripton = itemView.findViewById(R.id.note_description) as TextView
    val noteBottomRemove = itemView.findViewById(R.id.note_button_remove) as Button
}