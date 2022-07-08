package es.ipow.sharedpreferencescardview

import android.app.Application

class SharedPreferences:Application() {
    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}