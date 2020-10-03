package com.dev_candra.latihan_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(),View.OnClickListener {

    
    // menginisiasi widget
    private lateinit var editPanjang : EditText
    private lateinit var editLebar : EditText
    private lateinit var editTinggi : EditText
    private lateinit var textHasil : TextView
    private lateinit var buttonCalculate : Button

    private companion object {
        private const val stateResult = "tetap"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // mengaanssigment widget
        editPanjang = findViewById(R.id.edt_length)
        editLebar = findViewById(R.id.edit_width)
        editTinggi = findViewById(R.id.edit_height)
        buttonCalculate = findViewById(R.id.btn_calculate)
        textHasil = findViewById(R.id.hasil)
        buttonCalculate.setOnClickListener(this)
        // Menyimpan value pada saveInstance jika terjadi onCreate data tetap dijaga
        if (savedInstanceState != null){
            // Membuatnya kedalam sebuah objectt dan mengambil data dari ovveride saveInstance
            val result = savedInstanceState.getString(stateResult)
            textHasil.text = result
        }
        actioBar()
    }

    // membuat action Bar
    private fun actioBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "Latihan Activity"
        }
    }

    // implementasi pada onclick jika button diklik
    override fun onClick(v: View?) {
        val panjang = editPanjang.text.toString().trim()
        val lebar = editLebar.text.toString().trim()
        val tinggi = editTinggi.text.toString().trim()
        var isFalse = false

        when{
            panjang.isEmpty() -> {
                editPanjang.error = "Kolom panjang tidak boleh kosong"
                isFalse = true
            }
            lebar.isEmpty() -> {
                editLebar.error = "Kolom lebar tidak boleh kosong"
                isFalse = true
            }
            tinggi.isEmpty() -> {
                editTinggi.error = "Kolom tinggi tidak boleh kosong"
                isFalse = true
            }
        }
        if (!isFalse){
            val volumeHasil = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
            textHasil.text = volumeHasil.toString()
        }
    }

    // Membuat sebuah fungsi agar menjaga data tetap terjadi jika terjadi perubahan pada data
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(stateResult,textHasil.text.toString())
    }

}