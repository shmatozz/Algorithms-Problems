package internWeekOfferExam

import kotlin.math.max

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val days = Array(n) { 0 }

    for (i in 1..m) {
        val (l, r, x) = readln().split(' ').map { it.toInt() }
        for (j in l - 1 until r) {
            days[j] = max(days[j], x)
        }
    }

    println(days.sum())
}