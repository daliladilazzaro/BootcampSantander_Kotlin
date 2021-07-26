package com.example.contatosbootcamp

import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val REQUEST_CONTACT=1
    val LINEAR_LAYOUT_VERTICAL=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pedir a permissao do usuario pra usa os contatos dele
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),
            REQUEST_CONTACT)
        }else{
            setContacts()
        }
    }
    private fun onRequestPermissionResult(requestCode:Int, permissions:Array<out String>, grantResults:IntArray){
        if (requestCode == REQUEST_CONTACT) setContacts()
    }
    private fun setContacts(){
        val contactList: ArrayList<Contact> = ArrayList()
        //comum em html . tabelas listas
        val cursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        null, null, null, null)
        if (cursor!=null){
            while (cursor.moveToNext()){
                contactList.add(Contact(
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))))
            }
            cursor.close()
        }
        //chama a classe e passa o parametro lista que ele espera
        val adapter = ContactsAdapter(contactList)
        val contactRecyclerView = findViewById<RecyclerView>(R.id.contacts_recycler_view)

        contactRecyclerView.layoutManager=LinearLayoutManager(this, LINEAR_LAYOUT_VERTICAL, false)
        contactRecyclerView.adapter=adapter
    }
}