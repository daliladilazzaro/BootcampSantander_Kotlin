package com.example.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //fazendo um evendo onde pega um botão da activity e podendo dar um click
        val btnSetEvent=findViewById(R.id.set_event) as Button
        btnSetEvent.setOnClickListener{
            val intent=Intent(Intent.ACTION_INSERT).setData(CONTENT_URI)//CHAMA O CALENDARIO
                .putExtra(TITLE, "Bootcamp Santander")
                .putExtra(EVENT_LOCATION, "on line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())//aagora
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis()+(60*60*1000))

            startActivity(intent) // para startar a aplicacao
        }
    }
}