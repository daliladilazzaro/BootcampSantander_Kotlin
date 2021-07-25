package com.example.exnotificacoes

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {

    override fun onTokenRefresh(){
        Log.i("**newTokenService", FirebaseInstanceIdService.getInstance().token.toString())
    }
}