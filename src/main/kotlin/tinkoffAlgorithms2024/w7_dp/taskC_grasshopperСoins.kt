package tinkoffAlgorithms2024.w7_dp

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val coins = ("0 " + readln() + " 0").split(' ').map { it.toInt() }.toIntArray()

    val dp = IntArray(n) { 0 }
    val path = IntArray(n) { 0 }

    for (i in 1 until n) {
        var prevMax = i - 1
        val start = if (i - k < 0) {
            0
        } else {
            i - k
        }
        for (j in start until i) {
            if (dp[j] > dp[prevMax]) {
                prevMax = j
            }
        }
        dp[i] = dp[prevMax] + coins[i]
        path[i] = prevMax
    }

    val ans = mutableListOf(n)
    while (ans.last() - 1 != 0) {
        ans.add(path[ans.last() - 1] + 1)
    }

    println(dp[n - 1])
    println(ans.size - 1)
    for (i in ans.size - 1 downTo 0) {
        print("${ans[i]} ")
    }
    println()
}