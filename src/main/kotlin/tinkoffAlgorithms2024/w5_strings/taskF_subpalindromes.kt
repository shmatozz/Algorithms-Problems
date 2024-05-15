package tinkoffAlgorithms2024.w5_strings

import kotlin.math.min

fun main() {
    val s = readLine()!!
    val d1 = LongArray(s.length) { 0 }
    val d2 = LongArray(s.length) { 0 }

    var l = 0
    var r = -1
    for (i in s.indices) {
        var k = if (i > r) 1 else min(d1[l + r - i], (r - i + 1).toLong())
        while (i + k < s.length && i - k >= 0 && s[(i + k).toInt()] == s[(i - k).toInt()]) {
            k++
        }
        d1[i] = k
        if (i + k - 1 > r) {
            l = (i - k + 1).toInt()
            r = (i + k - 1).toInt()
        }
    }

    l = 0
    r = -1
    for (i in s.indices) {
        var k = if (i > r) 0 else min(d2[l + r - i + 1], (r - i + 1).toLong())
        while (i + k < s.length && i - k - 1 >= 0 && s[(i + k).toInt()] == s[(i - k - 1).toInt()]) {
            k++
        }
        d2[i] = k
        if (i + k - 1 > r) {
            l = (i - k).toInt()
            r = (i + k - 1).toInt()
        }
    }

    println((d1.sum() + d2.sum()))
}