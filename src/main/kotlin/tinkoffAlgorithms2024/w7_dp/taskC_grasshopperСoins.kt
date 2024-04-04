package tinkoffAlgorithms2024.w7_dp

import kotlin.math.min

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val coins = ("0 " + readln() + " 0").split(' ').map { it.toInt() }.toIntArray()
    val deque: ArrayDeque<Int> = ArrayDeque()

    val dp = IntArray(n) { 0 }
    val path = IntArray(n) { 0 }
    deque.add(0)
    for (i in 1 .. min(k, n - 1)) {
        dp[i] = dp[deque.first()] + coins[i]
        path[i] = deque.first()
        while (deque.isNotEmpty() && dp[deque.last()] <= dp[i]) {
            deque.removeLast()
        }
        deque.add(i)
    }

    for (i in k + 1 until n) {
        if (i - k > deque.first()) {
            deque.removeFirst()
        }

        dp[i] = dp[deque.first()] + coins[i]
        path[i] = deque.first()

        while (deque.isNotEmpty() && dp[deque.last()] <= dp[i]) {
            deque.removeLast()
        }
        deque.add(i)
    }

//    for (i in dp) print("$i ")
//    println()
//    for (i in path) print("$i ")
//    println()

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