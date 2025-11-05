package ru.gr05307.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.gr05307.painting.FractalPainter
import ru.gr05307.painting.convertation.Converter
import ru.gr05307.painting.convertation.Plain

class MainViewModel {
    var fractalImage: ImageBitmap = ImageBitmap(0, 0)
    var selectionOffset by mutableStateOf(Offset(0f, 0f))
    var selectionSize by mutableStateOf(Size(0f, 0f))
    private val plain = Plain(-2.0,1.0,-1.0,1.0)
    private val fractalPainter = FractalPainter(plain)
    private var mustRepaint by mutableStateOf(true)

    fun paint(scope: DrawScope){
        plain.width = scope.size.width
        plain.height = scope.size.height
        if (mustRepaint
            || fractalImage.width != plain.width.toInt()
            || fractalImage.height != plain.height.toInt()
        )
            fractalPainter.paint(scope)
        else
            scope.drawImage(fractalImage)
        mustRepaint = false
    }

    fun onImageUpdate(image: ImageBitmap) {
        fractalImage = image
    }

    fun onStartSelecting(offset: Offset){
        this.selectionOffset = offset
    }

    fun onStopSelecting(){
        val xMin = Converter.xScr2Crt(selectionOffset.x, plain)
        val yMin = Converter.yScr2Crt(selectionOffset.y+selectionSize.height, plain)
        val xMax = Converter.xScr2Crt(selectionOffset.x+selectionSize.width, plain)
        val yMax = Converter.yScr2Crt(selectionOffset.y, plain)
        plain.xMin = xMin
        plain.yMin = yMin
        plain.xMax = xMax
        plain.yMax = yMax
        selectionSize = Size(0f,0f)
        mustRepaint = true
    }

    fun onSelecting(offset: Offset){
        selectionSize = Size(selectionSize.width + offset.x, selectionSize.height + offset.y)
    }
}