package ru.gr05307.painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.gr05307.fractal.Mandelbrot
import ru.gr05307.math.Complex
import ru.gr05307.painting.convertation.Converter
import ru.gr05307.painting.convertation.Plain

class FractalPainter(private val plain: Plain): Painter {

    override var width: Float
        get() = plain.width
        set(value){
            plain.width = value
        }
    override var height: Float
        get() = plain.height
        set(value){
            plain.height = value
        }

    override fun paint(scope: DrawScope) {
        val m = Mandelbrot(nMax = 5000)
        repeat(width.toInt()){ iX ->
            val x = iX.toFloat()
            repeat(height.toInt()){ iY ->
                val y = iY.toFloat()
                scope.drawRect(
                    if(m.isInSet(Complex(
                        Converter.xScr2Crt(x, plain),
                        Converter.yScr2Crt(y,plain),
                        )
                    )) Color.Black else Color.White,
                    Offset(x, y),
                    Size(1f,1f),
                )

            }


        }
    }

}