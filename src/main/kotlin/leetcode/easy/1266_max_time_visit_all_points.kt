package leetcode.easy

import kotlin.math.abs
import kotlin.math.max

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var totalTime = 0
    var prevPoint = points[0]

    for (i in 1 until points.size) {
        val absX = abs(points[i][0] - prevPoint[0])
        val absY = abs(points[i][1] - prevPoint[1])
        totalTime += max(absX, absY)
        prevPoint = points[i]
    }

    return totalTime
}

fun main() {
    val a = arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))
    println(minTimeToVisitAllPoints(a))
}