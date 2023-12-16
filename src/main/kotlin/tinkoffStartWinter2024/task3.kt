package tinkoffStartWinter2024

import kotlin.math.max

fun check(credit: Int, prices: List<Int>): Int {
    var remainingCredit = credit

    for (price in prices) {
        if (remainingCredit >= price) {
            remainingCredit -= price
        }
    }

    return remainingCredit
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val prices = readln().split(" ").map { it.toInt() }

    var max = 0
    for (i in 0..m) {
        max = max(check(i, prices), max)
    }

    println(max)
}