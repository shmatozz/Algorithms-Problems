package tinkoffAlgorithms2024.w11_solution_methods2

import kotlin.math.max

fun calcDP(dp: Array<IntArray>, s: String) {
    val n = s.length
    for (length in 2..n) {
        for (i in 0..n-length) {
            val j = i + length - 1
            if (s[i] == s[j]) {
                dp[i][j] = if (length == 2) 2 else dp[i+1][j-1] + 2
            } else {
                dp[i][j] = max(dp[i+1][j], dp[i][j-1])
            }
        }
    }
}

fun main() {
    val s = readln()
    val dp = Array(s.length) { IntArray(s.length) { 0 } }

    for (i in s.indices) {
        dp[i][i] = 1
    }

    calcDP(dp, s)

//    for (i in dp.indices) {
//        for (j in dp.indices) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }

    var left = 0
    var right = s.length - 1
    var pLeft = 0
    var pRight = dp[0][s.length - 1] - 1
    val palindrome = CharArray(dp[0][s.length - 1])

    while (left <= right) {
        if (s[left] == s[right]) {
            palindrome[pLeft] = s[left]
            palindrome[pRight] = s[right]
            pLeft++
            pRight--
            left++
            right--
        } else if (dp[left + 1][right] > dp[left][right - 1]) {
            left++
        } else {
            right--
        }
    }

    println(dp[0][s.length - 1])
    println(palindrome.joinToString(""))
}