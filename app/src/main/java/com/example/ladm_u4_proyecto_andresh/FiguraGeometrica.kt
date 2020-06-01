package com.example.ladm_u4_proyecto_andresh

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica(){

    var x = 0f
    var y = 0f
    var tipo = 1 //1 Rectangulo 2 Circulo  3 Bitmao
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX =5
    var incY = 5
    var bitmap : Bitmap?=null

    constructor(x:Int,y:Int,alto:Int,ancho:Int):this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.alto = alto.toFloat()
        this.ancho = ancho.toFloat()//Constructor de rectuangulo
    }

    constructor(x:Int,y:Int,radio:Int):this(){//constructor del circulo
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio=radio.toFloat()
        this.tipo = 2

        ancho = this.radio*2    //tratar el circulo como un cuadrado
        alto= ancho

    }

    constructor(x:Int, y:Int, imagen:Bitmap):this(){
        bitmap=imagen
        this.x=x.toFloat()
        this.y=y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.width.toFloat()
        this.tipo=3
    }

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            2->{
                c.drawCircle(x+radio,y+radio,radio,p)
            }
            3 ->{
                c.drawBitmap(bitmap!!,x,y,p)
            }
        }
    }

    fun estaEnArea(event: MotionEvent):Boolean{
        if(event.x>= x && event.x <= x+ancho){
            if(event.y >= y && event.y <=y+alto) {
                return true
            }
        }
        return false
    }

    fun estaEnArea(posX:Float,posY:Float):Boolean{
        if(posX>= x && posX <= x+ancho){
            if(posY >= y && posY <=y+alto) {
                return true
            }
        }
        return false
    }

    fun arrastrar(event:MotionEvent){
        x = event.x-(ancho/2)
       // y = event.y-(alto/2)
    }

    fun rebote(ancho:Int, alto:Int){
        x+= incX
        if(x<= -100||x>=ancho){
            incX*=-1
        }
        y+=incY
        if(y<=-100||y>=alto){
            incY*=-1
        }
    }

    fun colision(objetoB: FiguraGeometrica):Boolean{
        //Caso 1
        if (objetoB.estaEnArea(x+ancho,y+alto)){
            return true
        }
        //Caso2
        if (objetoB.estaEnArea(x,y+alto)){
            return true
        }
        //Caso3
        if (objetoB.estaEnArea(x+ancho,y)){
            return true
        }
        //Caso4
        if (objetoB.estaEnArea(x,y)){
            return true
        }
        return false
    }

    fun cambiarDireccion(){
        
    }
}