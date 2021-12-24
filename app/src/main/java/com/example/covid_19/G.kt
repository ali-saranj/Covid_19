package com.example.covid_19

import android.app.Application
import android.content.Context

class G : Application() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}