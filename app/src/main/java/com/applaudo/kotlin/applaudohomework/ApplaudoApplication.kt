package com.applaudo.kotlin.applaudohomework

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class ApplaudoApplication : Application() {

    private var mGson: Gson? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun gson(): Gson {
        if (mGson == null) {
            val gsonBuilder: GsonBuilder = GsonBuilder()
            mGson = gsonBuilder.create()
        }
        return mGson!!
    }

    companion object {
        var instance: ApplaudoApplication? = null
            private set
    }
}
