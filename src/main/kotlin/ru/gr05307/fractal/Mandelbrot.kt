package ru.gr05307.fractal

import ru.gr05307.math.Complex

class Mandelbrot(
    val nMax: Int = 200,
    val r: Double = 2.0,
) {
    fun isInSet(c: Complex): Boolean{
        val z = Complex()
        repeat(nMax) {
            z *= z
            z += c
            if (z.absoluteValue2 >= r * r) return false
        }
        return true
    }
}