package tinkoffAlgorithms2024.w7_dp

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val matrix = Array(n) { IntArray(m) { 0 } }
    val dp = Array(n) { IntArray(m) { 0 } }

    for (i in matrix.indices) {
        matrix[i] = readln().split(' ').map { it.toInt() }.toIntArray()
    }

    for (i in 0 until m) {
        dp[n - 1][i] = matrix[n - 1][i]
    }
    for (i in 0 until n) {
        dp[i][m - 1] = matrix[i][m - 1]
    }

    for (i in n - 2 downTo 0) {
        for (j in m - 2 downTo 0) {
            if (dp[i][j + 1] > 0 && dp[i + 1][j + 1] > 0 && dp[i + 1][j] > 0 && matrix[i][j] > 0) {
                dp[i][j] = min(dp[i][j + 1], min(dp[i + 1][j + 1], dp[i + 1][j])) + 1
            } else if (matrix[i][j] > 0) {
                dp[i][j] = 1
            }
        }
    }

    var ansI = 0
    var ansJ = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (dp[i][j] >= dp[ansI][ansJ]) {
                ansI = i; ansJ = j
            }
        }
    }

    println(dp[ansI][ansJ])
    println("${ansI + 1} ${ansJ + 1}")
//    for (i in 0 until n) {
//        for (j in 0 until m) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }
}