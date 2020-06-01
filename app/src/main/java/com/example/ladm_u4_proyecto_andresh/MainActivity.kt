package com.example.ladm_u4_proyecto_andresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var lienzo : Lienzo ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo= Lienzo(this)
        setContentView(lienzo!!)

        Choque(this).start()
    }
}
