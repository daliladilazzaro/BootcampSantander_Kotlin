package com.example.implementandotestes

import android.app.Notification
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        fetchListContact()
        bindViews()
    }
private fun fetchListContact(){
    val list = arrayListOf(
        Contact(
            "Joao Carlos",
            "(11) 98765-9874",
            "img.jpg"),
        Contact(
            "Melissa de Sá",
            "(11) 91234-4567",
            "img2.jpg"))
    getInstanceSharePreferences().edit{
        val json = Gson.toJson(list)
        putString("contacs", json)
        commit()
    }
}
private fun getInstanceSharePreferences(): SharedPreferences{
    return getSharedPreferences("com.exemple.implementandoteste.PREFERENCE",Context)
}
    private  fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle=ActionBarDrawerToggle(this, drawerLayout, toolbar,
            "Abrir", "Fechar")
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager=LinearLayoutManager(this)
        updateList()
    }
    private fun getListContacts():List<Contact>{
        val list=getInstanceSharePreferences().getString("contacts", "[]")
        val turnsType=object :TypeToken<List<Contact>>{}.type
        return Gson().fromJson(list, turnsType)
    }
    private fun updateList(){
        val list = getListContacts()
        adapter.updateList(list)
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}