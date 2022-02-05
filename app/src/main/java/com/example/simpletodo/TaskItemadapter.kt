package com.example.simpletodo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemadapter(val ListOfItems: List<String>, val longClickListener: OnLongClickListener) :
    RecyclerView.Adapter<TaskItemadapter.ViewHolder>(){
interface OnLongClickListener{

    fun onItemLongClicked(position:Int)
}
inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val textView: TextView = itemView.findViewById(android.R.id.text1)
 init{

     itemView.setOnLongClickListener{
        longClickListener.onItemLongClicked(adapterPosition)
         true

     }

 }
}

    override fun getItemCount(): Int {

     return ListOfItems.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   val contact: Contact = mContacts.get(position)
     //   // Set item views based on your views and data model
      //  val textView = viewHolder.nameTextView
       // textView.setText(contact.name)
      //  val button = viewHolder.messageButton
       // button.text = if (contact.isOnline) "Message" else "Offline"
       // button.isEnabled = contact.isOnline
        val item = ListOfItems.get(position)
    holder.textView.text=item
    }
}