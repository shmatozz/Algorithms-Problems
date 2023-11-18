package easy

import printMatrix

fun main() {
    val m = readln().toInt()
    val first = readln().split(" ").map { it.toInt() }.toTypedArray()
    val n = readln().toInt()
    val second = readln().split(" ").map { it.toInt() }.toTypedArray()

    val intersection = Array(n) { Array(m) { 0 } }
    for (i in second.indices) {
        for (j in first.indices) {
            if (second[i] == first[j]) {
                intersection[i][j] = 1
            }
        }
    }

    var maxLen = 0
    var indMaxLen = 0
    val dp = Array(n) { Array(m) { 0 } }
    for (i in 0 until m) {
        dp[0][i] = intersection[0][i]
        if (dp[0][i] > maxLen) {
            maxLen = dp[0][i]
            indMaxLen = i
        }
    }

    for (i in 0 until n) {
        dp[i][0] = intersection[i][0]
        if (dp[i][0] > maxLen) {
            maxLen = dp[i][0]
            indMaxLen = 0
        }
    }


    for (i in 1 until n) {
        for (j in 1 until m) {
            if (intersection[i][j] == 1) {
                dp[i][j] = dp[i - 1][j - 1] + intersection[i][j]
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j]
                    indMaxLen = j
                }
            }
        }
    }

    for (i in indMaxLen - (maxLen - 1) ..  indMaxLen) {
        print("${first[i]} ")
    }
    println()
}