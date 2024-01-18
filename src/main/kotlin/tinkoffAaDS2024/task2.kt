package tinkoffAaDS2024

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val text = readln()

    var maxLen = 0
    var minLen = n
    var curLen = 0
    for (i in text.indices) {
        if (text[i] == '#') {
            maxLen = max(maxLen, curLen)
            minLen = min(minLen, curLen)
            curLen = 0
        } else {
            curLen++
        }
    }
    maxLen = max(maxLen, curLen)
    minLen = min(minLen, curLen)

    println("$minLen $maxLen")
}