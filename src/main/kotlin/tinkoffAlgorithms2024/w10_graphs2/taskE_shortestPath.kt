package tinkoffAlgorithms2024.w10_graphs2

class Node(val to: Int, val w: Int)

fun dijkstra(n: Int, graph:  MutableMap<Int, MutableList<Node>>): LongArray {
    val dist = LongArray(n + 1) { Long.MAX_VALUE }
    dist[1] = 0

    val queue = ArrayDeque<Int>()
    queue.add(1)

    while (queue.isNotEmpty()) {
        val top = queue.first()
        queue.removeFirst()

        for (next in graph[top]!!) {
            if (dist[next.to] > dist[top] + next.w) {
                dist[next.to] = dist[top] + next.w
                queue.addLast(next.to)
            }
        }
    }

    return dist
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Node>>()

    repeat(m) {
        val (from, to, w) = readln().split(' ').map { it.toInt() }

        graph[from] = graph.getOrDefault(from, mutableListOf())
        graph[from]!!.add(Node(to, w))

        graph[to] = graph.getOrDefault(to, mutableListOf())
        graph[to]!!.add(Node(from, w))
    }

    val dist = dijkstra(n, graph)

    for (i in 1 .. n) {
        print("${dist[i]} ")
    }
    println()
}