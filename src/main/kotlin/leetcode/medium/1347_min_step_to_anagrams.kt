package leetcode.medium

import kotlin.math.abs

fun minSteps(s: String, t: String): Int {
    val sCounter = IntArray(26) { 0 }
    val tCounter = IntArray(26) { 0 }

    for (ch in s) {
        sCounter[ch - 'a'] += 1
    }

    for (ch in t) {
        tCounter[ch - 'a'] += 1
    }

    var stepsCounter = 0

    for (i in 0 until 26) {
        stepsCounter += abs(sCounter[i] - tCounter[i])
    }

    return stepsCounter / 2
}

fun main() {
    println(minSteps("aba", "aaa"))
    println(minSteps("leetcode", "practice"))
    println(minSteps("anagram",  "mangaar"))
}