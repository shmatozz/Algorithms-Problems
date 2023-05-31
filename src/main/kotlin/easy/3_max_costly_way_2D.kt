package easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

// 2D dynamic programming with path
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
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + costsMatrix[i][j]
        }
    }

    var way = String()
    var i = n - 1; var j = m - 1; var k = 0

    while (i != 0 || j != 0) {
        if (i == 0) {
            way += "R "
            j--
        } else if (j == 0) {
            way += "D "
            i--
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                way += "D "
                i--
            } else {
                way += "R "
                j--
            }
        }
        k++
    }

    println(dp[n - 1][m - 1])
    println(way.reversed().trim())

    reader.close()
    writer.close()
}