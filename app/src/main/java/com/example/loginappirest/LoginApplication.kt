package com.example.loginappirest

import android.app.Application

class LoginApplication : Application() {
    companion object{
        lateinit var storeAPI: ReqResApi
    }

    override fun onCreate() {
        super.onCreate()
        //Volley
        storeAPI = ReqResApi.getInstance(this)
    }
}