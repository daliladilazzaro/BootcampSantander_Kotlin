package com.example.implementandotestes

import android.content.SharedPreferences

class ContactHelper(private val sharedPreferences: SharedPreferences) {
fun getListContacts():List<Contact>{
    val list = sharedPreferences.getString("contacts", "[]")
    val turnsType=object :TypeToken<List<Contact>>{}.type
    return Gson().fromJson(list, turnsType)
    // return arrayListOf()
}
    fun setListContact(list: List<Contact>){
        sharedPreferences.edit().putString("contacts", Gson().toJson(list)).commit()
    }
}