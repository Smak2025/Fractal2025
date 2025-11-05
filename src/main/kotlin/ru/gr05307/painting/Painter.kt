package ru.gr05307.painting

import androidx.compose.ui.graphics.drawscope.DrawScope

interface Painter {
    fun paint(scope: DrawScope)
}
