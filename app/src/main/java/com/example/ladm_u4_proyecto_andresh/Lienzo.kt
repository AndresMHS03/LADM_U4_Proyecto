package com.example.ladm_u4_proyecto_andresh

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity): View(p){
    var puntero = p

    var raqueta1 = FiguraGeometrica(100,1800,50,200)
    var raqueta2 = FiguraGeometrica(400,1800,50,200)
    var pelotita = FiguraGeometrica(600,900,10)

    var ladrillo11 = FiguraGeometrica(50,400,50,200)
    var ladrillo12 = FiguraGeometrica(50,451,50,200)
    var ladrillo13 = FiguraGeometrica(50,502,50,200)
    var ladrillo14 = FiguraGeometrica(50,553,50,200)
    var ladrillo15 = FiguraGeometrica(50,604,50,200)
    var ladrillo16 = FiguraGeometrica(50,655,50,200)

    var ladrillo21 = FiguraGeometrica(251,400,50,200)
    var ladrillo22 = FiguraGeometrica(251,451,50,200)
    var ladrillo23 = FiguraGeometrica(251,502,50,200)
    var ladrillo24 = FiguraGeometrica(251,553,50,200)
    var ladrillo25 = FiguraGeometrica(251,604,50,200)
    var ladrillo26 = FiguraGeometrica(251,655,50,200)

    var ladrillo31 = FiguraGeometrica(451,401,50,200)
    var ladrillo32 = FiguraGeometrica(451,452,50,200)
    var ladrillo33 = FiguraGeometrica(451,503,50,200)
    var ladrillo34 = FiguraGeometrica(451,554,50,200)
    var ladrillo35 = FiguraGeometrica(451,605,50,200)
    var ladrillo36 = FiguraGeometrica(451,656,50,200)

    var ladrillo41 = FiguraGeometrica(651,401,50,200)
    var ladrillo42 = FiguraGeometrica(651,452,50,200)
    var ladrillo43 = FiguraGeometrica(651,503,50,200)
    var ladrillo44 = FiguraGeometrica(651,554,50,200)
    var ladrillo45 = FiguraGeometrica(651,605,50,200)
    var ladrillo46 = FiguraGeometrica(651,656,50,200)

    var ladrillo51 = FiguraGeometrica(851,401,50,200)
    var ladrillo52 = FiguraGeometrica(851,452,50,200)
    var ladrillo53 = FiguraGeometrica(851,503,50,200)
    var ladrillo54 = FiguraGeometrica(851,554,50,200)
    var ladrillo55 = FiguraGeometrica(851,605,50,200)
    var ladrillo56 = FiguraGeometrica(851,656,50,200)



    var punteroFiguraGeometrica : FiguraGeometrica?= null

    override fun onDraw(c: Canvas?) {
        super.onDraw(c)
        var paint = Paint()

        c!!.drawColor(Color.BLACK)

        paint.style =Paint.Style.FILL
        paint.color = Color.DKGRAY
        raqueta1.pintar(c,paint)
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.LTGRAY
        raqueta2.pintar(c,paint)
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        pelotita.pintar(c,paint)

        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.YELLOW
        ladrillo11.pintar(c,paint)
        ladrillo12.pintar(c,paint)
        ladrillo13.pintar(c,paint)
        ladrillo14.pintar(c,paint)
        ladrillo15.pintar(c,paint)
        ladrillo16.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        ladrillo21.pintar(c,paint)
        ladrillo22.pintar(c,paint)
        ladrillo23.pintar(c,paint)
        ladrillo24.pintar(c,paint)
        ladrillo25.pintar(c,paint)
        ladrillo26.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        ladrillo31.pintar(c,paint)
        ladrillo32.pintar(c,paint)
        ladrillo33.pintar(c,paint)
        ladrillo34.pintar(c,paint)
        ladrillo35.pintar(c,paint)
        ladrillo36.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        ladrillo41.pintar(c,paint)
        ladrillo42.pintar(c,paint)
        ladrillo43.pintar(c,paint)
        ladrillo44.pintar(c,paint)
        ladrillo45.pintar(c,paint)
        ladrillo46.pintar(c,paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.MAGENTA
        ladrillo51.pintar(c,paint)
        ladrillo52.pintar(c,paint)
        ladrillo53.pintar(c,paint)
        ladrillo54.pintar(c,paint)
        ladrillo55.pintar(c,paint)
        ladrillo56.pintar(c,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")

        when(event.action){
            MotionEvent.ACTION_DOWN->{//--------------------------------------Tocar
                //Revisar quien esta en el area
                if(raqueta1.estaEnArea(event)){
                    punteroFiguraGeometrica=raqueta1
                    puntero.setTitle("Tocaste la raqueta")
                }
            /*    if(cuadrado.estaEnArea(event)){
                    punteroFiguraGeometrica = cuadrado
                    puntero.setTitle("TOCASTE CUADRADO")
                }
                if(rectangulo.estaEnArea(event)){
                    punteroFiguraGeometrica = rectangulo
                    puntero.setTitle("TOCASTE RECTANGULO")
                }
                if(circulo2.estaEnArea(event)){
                    punteroFiguraGeometrica = circulo2
                    puntero.setTitle("TOCASTE CIRCULO2")
                }
                if(icono.estaEnArea(event)){
                    punteroFiguraGeometrica = icono
                    puntero.setTitle("TOCASTE LA CUCARACHA D:")
                    sonido.start()
                }*/
            }
            MotionEvent.ACTION_MOVE->{//--------------------------------------------Se mueve
                if(punteroFiguraGeometrica!=null){
                    punteroFiguraGeometrica!!.arrastrar(event)
                    if(punteroFiguraGeometrica==raqueta1){//pregunto si a quien arrasto es el circulo
                        if(punteroFiguraGeometrica!!.colision(pelotita)){
                            //circulo 1 hizo colision
                            puntero.setTitle("Circulo1 toco cuadrado :D")

                        }
                        if(punteroFiguraGeometrica!!.colision(raqueta2)){
                            puntero.setTitle("Raqueta 1 toco a la Raqueta 2")
                        }

                    }
                 /*   if(punteroFiguraGeometrica==circulo2){
                        if(punteroFiguraGeometrica!!.colision(circulo)){
                            puntero.setTitle("el circulo2 toco al circulo1 D:")
                        }
                    }*/
                }

            }//----------------------------------------------------------------Soltar
            MotionEvent.ACTION_UP->{
                punteroFiguraGeometrica=null
            }
        }
        invalidate()
        return true
    }

    fun animarCirculo(){
        pelotita.rebote(width,height)
       /* circulo.rebote(width,height)
        icono.rebote(width,height)*/
        if(pelotita.colision(ladrillo11)){

        }
        invalidate()
    }

}