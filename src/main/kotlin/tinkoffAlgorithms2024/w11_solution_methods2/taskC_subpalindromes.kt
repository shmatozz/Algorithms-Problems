package tinkoffAlgorithms2024.w11_solution_methods2

import kotlin.math.max

fun calcDP(dp: Array<IntArray>, s: String, left: Int, right: Int) : Int {
    if (left == right) {
        return 1
    } else if (left > right) {
        return 0
    }

    if (s[left] != s[right]) {
        dp[left][right] = max(
            calcDP(dp, s, left + 1,  right),
            calcDP(dp, s, left,  right - 1)
        )
    } else {
        dp[left][right] = calcDP(dp, s, left + 1, right - 1) + 2
    }

    return dp[left][right]
}

fun main() {
    val s = readln()
    val dp = Array(s.length) { IntArray(s.length) { -1 } }

    calcDP(dp, s, 0, s.length - 1)

    var left = 0
    var right = s.length - 1
    var pLeft = 0
    var pRight = dp[0][s.length - 1] - 1
    val palindrome = CharArray(dp[0][s.length - 1])

    while (left <= right) {
        if (left == right && dp[left][right] == 1) {
            palindrome[pLeft] = s[left]
            pLeft++
            left++
        } else if (s[left] == s[right]) {
            palindrome[pLeft] = s[left]
            palindrome[pRight] = s[right]
            pLeft++; left++
            pRight--; right--
        } else if (dp[left + 1][right] > dp[left][right - 1]) {
            left++
        } else {
            right--
        }
    }

    println(dp[0][s.length - 1])
    println(palindrome.joinToString(""))
}