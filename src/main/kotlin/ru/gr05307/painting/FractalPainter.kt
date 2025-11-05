package ru.gr05307.painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.gr05307.fractal.Mandelbrot
import ru.gr05307.math.Complex
import ru.gr05307.painting.convertation.Converter
import ru.gr05307.painting.convertation.Plain
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.sin

class FractalPainter(private val plain: Plain): Painter {

    private fun getColor(probability: Float) = if (probability == 1f)
        Color.Black
    else Color(
        red = cos(7 * probability).absoluteValue,
        green = sin(12 * (1f - probability)).absoluteValue,
        blue = (sin(4 * probability) * cos(4 * (1 - probability))).absoluteValue
    )

    override fun paint(scope: DrawScope) {
        plain.width = scope.size.width
        plain.height = scope.size.height
        val m = Mandelbrot(nMax = 200)
        repeat(scope.size.width.toInt()){ iX ->
            val x = iX.toFloat()
            repeat(scope.size.height.toInt()){ iY ->
                val y = iY.toFloat()
                scope.drawRect(
                    getColor(m.isInSet(Complex(
                        Converter.xScr2Crt(x, plain),
                        Converter.yScr2Crt(y,plain),
                        )
                    )),
                    Offset(x, y),
                    Size(1f,1f),
                )

            }


        }
    }

}