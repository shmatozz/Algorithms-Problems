package tinkoffAlgorithms2024.w7_dp

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val ladder = readln().split(' ').map { it.toInt() }.toIntArray()
    val dp = IntArray(n + 1) { 0 }

    dp[1] = ladder[0]

    for (i in 1 until n) {
        dp[i + 1] = min(dp[i], dp[i - 1]) + ladder[i]
    }

    println(dp[n])
}