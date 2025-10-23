package ru.gr05307.painting

import androidx.compose.ui.graphics.drawscope.DrawScope

interface Painter {
    val width: Float
    val height: Float

    fun paint(scope: DrawScope)
}
