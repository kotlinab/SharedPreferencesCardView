package es.ipow.sharedpreferencescardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import es.ipow.sharedpreferencescardview.SharedPreferences.Companion.prefs
import es.ipow.sharedpreferencescardview.databinding.ActivityAccessBinding

class AccessActivity : AppCompatActivity() {
    private lateinit var b : ActivityAccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAccessBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUi()
    }
    fun initUi(){
        b.btnClose.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val userName = prefs.getName()
        b.tvHello.text = "¡Hola $userName!"
        if(prefs.getCheckColor()){
            val theColor = getMyColor(prefs.getColor())
            b.cardView.setCardBackgroundColor(ContextCompat.getColor(this, theColor) )
        }
    }

    fun getMyColor(color:String):Int{
        val resourceColor =  when(color){
            "Amarillo" -> R.color.amarillo
            "Naranja" -> R.color.naranja
            "Rojo" -> R.color.rojo
            "Rosa" -> R.color.rosa
            "Azul" -> R.color.azul
            "Verde" -> R.color.verde
            else -> R.color.white
        }
        return resourceColor
    }
}