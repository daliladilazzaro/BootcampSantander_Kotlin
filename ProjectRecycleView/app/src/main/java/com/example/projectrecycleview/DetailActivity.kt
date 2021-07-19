package com.example.projectrecycleview

import android.os.Bundle
import android.widget.TextView
//import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity :AppCompatActivity (){
    private var contact: Contact?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)
        initToolbar()
        getExtras()
        bindView()
    }


    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun bindView(){
        findViewById<TextView>(R.id.tv_nome).text=contact?.nome
        findViewById<TextView>(R.id.tv_telefone).text=contact?.telefone
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    companion object{
        const val EXTRA_CONTACT:String = "EXTRA_CONTACT"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}