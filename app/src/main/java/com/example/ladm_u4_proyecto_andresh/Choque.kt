package com.example.ladm_u4_proyecto_andresh

class Choque(p:MainActivity):Thread(){
    var puntero = p

    override fun run(){
        super.run()

        while(true){
            sleep(10)
            puntero.runOnUiThread {
                puntero.lienzo!!.animarCirculo()
            }
        }
    }
}