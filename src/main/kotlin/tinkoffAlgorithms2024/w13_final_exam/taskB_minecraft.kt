package tinkoffAlgorithms2024.w13_final_exam

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val heights = readln().split(' ').map { it.toLong() }.toLongArray()
    val stack = ArrayDeque<Int>()

    var maxArea = 0L
    var index = 0
    while (index < n) {
        if (stack.isEmpty() || heights[stack.last()] <= heights[index]) {
            stack.addLast(index)
            index++
        } else {
            val top = stack.removeLast()

            val area = if (stack.isEmpty()) {
                heights[top] * index
            } else {
                heights[top] * (index - stack.last() - 1)
            }

            maxArea = max(maxArea, area)
        }
    }

    while (stack.isNotEmpty()) {
        val top = stack.removeLast()

        val area = if (stack.isEmpty()) {
            heights[top] * index
        } else {
            heights[top] * (index - stack.last() - 1)
        }

        maxArea = max(maxArea, area)
    }

    println(maxArea)
}