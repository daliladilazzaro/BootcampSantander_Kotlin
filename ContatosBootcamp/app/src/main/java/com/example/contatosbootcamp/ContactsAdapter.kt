package com.example.contatosbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//ele gera uma lista e herda d componentes de uma recycler que incorpora esses outros metodos
class ContactsAdapter(val contactsList:ArrayList<Contact>):RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        //ele chama os objetos criados no layout
        val view =LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        holder.bindItem(contactsList[position])
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindItem(contact: Contact){
            val textName=itemView.findViewById<TextView>(R.id.contact_name)
            val textPhone=itemView.findViewById<TextView>(R.id.contact_phone)
    //vão recever os contacts e o view holder vai pegar a posicao no bindeviewholder e vai achar o layout no textfild e colocar o texto conforme a posicao
            textName.text=contact.name
            textPhone.text=contact.phoneNumber
        }
    }
}