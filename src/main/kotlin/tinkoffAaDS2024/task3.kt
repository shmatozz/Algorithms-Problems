package tinkoffAaDS2024

fun main() {
    val n = readln().toInt()
    val heights = readln().split(" ").map { it.toInt() }.toIntArray()

    var avgDiffs = 0.0
    for (i in 0 until heights.size - 1) {
        avgDiffs += (heights[i] + heights[i + 1]) / 2.0
    }

    println(avgDiffs / (heights.size - 1))
}