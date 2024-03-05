package tinkoffAlgorithms2024.w3_trees

import java.util.*

fun main() {
    val n = readln().toInt()
    val p = readln().split(' ').map { it.toInt() }.toIntArray()

    val heights = IntArray(n) { 0 }
    val g = Array<MutableList<Int>>(n) { mutableListOf() }
    for (i in p.indices) {
        heights[i + 1] = heights[p[i]] + 1
        g[i + 1].add(p[i])
        g[p[i]].add(i + 1)
    }

    val visited = IntArray(n) { -1 }
    val ranges = IntArray(n) { 0 }
    val queue: Queue<Int> = LinkedList()
    val start = heights.indexOf(heights.max())
    visited[start] = 1
    queue.add(start)
    while (queue.isNotEmpty()) {
        val v = queue.peek();
        queue.remove()
        for (e in g[v]) {
            if (visited[e] == -1) {
                ranges[e] = ranges[v] + 1
                visited[e] = 1
                queue.add(e)
            }
        }
    }

    println("${heights.max()} ${ranges.max()}")
    for (i in heights) print("$i ")
}