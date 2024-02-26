package tinkoffAlgorithms2024.enrollTest

import kotlin.math.sqrt

fun main() {
    var totalPoints = 0

    repeat(3) {
        val (x, y) = readln().split(" ").map { it.toDouble() }

        val dist = sqrt(x * x + y * y)

        if (dist in 0.0..0.1) {
            totalPoints += 3
        } else if (0.1 < dist && dist <= 0.8) {
            totalPoints += 2
        } else if (0.8 < dist && dist <= 1) {
            totalPoints += 1
        }
    }

    println(totalPoints)
}