package es.ipow.sharedpreferencescardview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import es.ipow.sharedpreferencescardview.SharedPreferences.Companion.prefs
import es.ipow.sharedpreferencescardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var opColor = "Amarillo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        getSpinner( b.spinner, R.array.colores)
        initUI()
        checkUserValues()
    }


    fun initUI(){
        b.bMainAct.setOnClickListener {
            accessSharedPreferences()
        }
    }
    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }
    fun accessSharedPreferences(){
        if (b.etName.text.toString().isNotEmpty()){
            prefs.saveName(b.etName.text.toString())
            prefs.saveCheckColor(b.chkColor.isChecked)
            prefs.saveColor(opColor)
            goAccess()
        }else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, AccessActivity::class.java))
    }

    fun getSpinner(spinner: Spinner,  idValores:Int){
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, idValores,
            android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                opColor = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                opColor = "Amarillo"
            }
        }
    }

}