package easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

// 2D dynamic programming
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val costsMatrix = Array(n) { Array(m) { 0 } }
    val dp = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        costsMatrix[i] = reader.readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    dp[0][0] = costsMatrix[0][0]
    for (i in 1 until m) {
        dp[0][i] = dp[0][i - 1] + costsMatrix[0][i]
    }
    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][0] + costsMatrix[i][0]
    }

    for (i in 1 until n) {
        for (j in 1 until m) {
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + costsMatrix[i][j]
        }
    }

    println(dp[n - 1][m - 1])

    reader.close()
    writer.close()
}