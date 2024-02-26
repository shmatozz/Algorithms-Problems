package tinkoffAlgorithms2024.w1_search_sort

import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val c = readln().toDouble()
    val epsilon = 1e-10
    var left = 0.0
    var right = c
    var x = 0.0

    while (abs(right - left) > epsilon) {
        x = (left + right) / 2

        if (x * x + sqrt(x + 1) == c) {
            break
        } else if (x * x + sqrt(x + 1) < c) {
            left = x
        } else if (x * x + sqrt(x + 1) > c) {
            right = x
        }
    }

    println(x)
}