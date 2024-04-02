package tinkoffAlgorithms2024.w7_dp

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 2) { 0 }
    dp[1] = 3
    dp[2] = 8

    for (i in 3..n) {
        dp[i] = dp[i - 1] * 2 + dp[i - 2] * 2
    }

    println(dp[n])
}