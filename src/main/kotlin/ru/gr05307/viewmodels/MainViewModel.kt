package ru.gr05307.viewmodels

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.gr05307.painting.FractalPainter
import ru.gr05307.painting.convertation.Plain

class MainViewModel {
    private val plain = Plain(-2.0,1.0,-1.0,1.0)
    private val fractalPainter = FractalPainter(plain)
    fun paint(scope: DrawScope){
        fractalPainter.width = scope.size.width
        fractalPainter.height = scope.size.height
        fractalPainter.paint(scope)
    }

}