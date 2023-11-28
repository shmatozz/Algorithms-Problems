package coderunYandex.medium

fun main(args: Array<String>) {
    val n = readln().toInt()
    val days = Array(n) { 0 }
    val dp = Array(n + 1) { 0 }

    for (i in 0 until n) {
        days[i] = readln().toInt()
        dp[i + 1] = dp[i]
        if (days[i] > 100) {
            dp[i + 1]++
        }
    }

    val totalCoupons = dp.last()

    for (i in dp) print("$i ")


}