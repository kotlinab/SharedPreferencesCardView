package es.ipow.sharedpreferencescardview

import android.content.Context

class Prefs (val context: Context){
    val DATABASE = "MyDB"
    val USER_NAME = "UserName"
    val CHECK_COLOR = "Check_Color"
    val COLOR = "Color"
    val storage = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE)

    fun saveName(name:String){
        storage.edit().putString(USER_NAME, name).apply()
    }
    fun saveColor(color:String){
        storage.edit().putString(COLOR, color).apply()
    }

    fun saveCheckColor(check:Boolean){
        storage.edit().putBoolean(CHECK_COLOR, check).apply()
    }

    fun getName():String{
        return storage.getString(USER_NAME, "")!!
    }
    fun getColor():String{
        return storage.getString(COLOR, "Rojo")!!
    }
    fun getCheckColor():Boolean{
        return storage.getBoolean(CHECK_COLOR, false)
    }

    fun wipeData(){
        storage.edit().clear().apply()
    }
}