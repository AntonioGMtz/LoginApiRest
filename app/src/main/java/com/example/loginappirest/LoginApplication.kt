package com.example.loginappirest

import android.app.Application

class LoginApplication : Application() {
    companion object{
        lateinit var reqResApi: ReqResApi
    }

    override fun onCreate() {
        super.onCreate()
        //Volley
        reqResApi = ReqResApi.getInstance(this)
    }
}