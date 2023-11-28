package coderunYandex.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// dynamic programming 2D
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine().split(' ').map { it.toInt() }
    val dp = Array(n) { Array(m) { 0 } }

    dp[0][0] = 1
    for (i in 0 until n) {
        for (j in 0 until m) {
            if ((i == 0 && j == 0) || dp[i][j] != 0) {
                if (i + 2 < n && j + 1 < m) {
                    dp[i + 2][j + 1] += dp[i][j]
                }
                if (i + 1 < n && j + 2 < m) {
                    dp[i + 1][j + 2] += dp[i][j]
                }
            }
        }
    }

    println(dp[n - 1][m - 1])

    reader.close()
    writer.close()
}