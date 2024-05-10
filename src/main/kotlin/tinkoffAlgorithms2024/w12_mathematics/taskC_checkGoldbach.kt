package tinkoffAlgorithms2024.w12_mathematics

import kotlin.math.sqrt

fun isPrime(n: Int): Boolean {
    for (i in 2 until sqrt(n.toFloat()).toInt() + 1) {
        if (n % i == 0) {
            return false
        }
    }

    return true
}

fun main() {
    val n = readln().toInt()

    for (p in 2 .. n / 2) {
        val q = n - p
        if (isPrime(p) && isPrime(q)) {
            println("$p $q")
            break
        }
    }
}