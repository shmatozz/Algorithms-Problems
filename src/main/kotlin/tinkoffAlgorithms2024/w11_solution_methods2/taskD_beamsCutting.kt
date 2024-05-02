package tinkoffAlgorithms2024.w11_solution_methods2

import kotlin.math.min

fun main() {
    val (l, n) = readln().split(' ').map { it.toInt() }
    val cuts = readln().split(' ').map { it.toInt() }.toMutableList()
    cuts.add(0, 0)
    cuts.add(l)

    val dp = Array(n + 2) { IntArray(n + 2) { 0 } }

    for (i in 1 until n + 2) {
        for (j in i - 2 downTo 0) {
            dp[i][j] = Int.MAX_VALUE
            for (k in j + 1 until i) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
            }
            dp[i][j] += cuts[i] - cuts[j]
        }
    }

//    for (i in 0 until n + 2) {
//        for (j in 0 until n + 2) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }

    println(dp[n + 1][0])
}