package ru.gr05307.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope

@Composable
fun PaintPanel(
    modifier: Modifier = Modifier,
    onPaint: (DrawScope)->Unit = {}
) {
    Canvas(modifier = modifier){
        onPaint(this)
    }
}