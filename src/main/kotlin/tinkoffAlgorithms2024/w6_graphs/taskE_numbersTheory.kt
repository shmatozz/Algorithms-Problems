package tinkoffAlgorithms2024.w6_graphs

fun main() {
    val n = readln().toInt()
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    for (i in 1 .. n) {
        if (graph.getOrDefault(i % n, 0) == 0) {
            graph[i] = mutableListOf()
        }
        graph[i]?.add(Pair((i + 1) % n, 1))
        graph[i]?.add(Pair((i * 10) % n, 0))
    }

    val queue = ArrayDeque<Int>()
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(1)
    dist[1] = 0
    while (queue.isNotEmpty()) {
        val cur = queue.first()
        queue.removeFirst()
        for (v in graph.getOrDefault(cur, mutableListOf())) {
            if (dist[v.first] > dist[cur] + v.second) {
                dist[v.first] = dist[cur] + v.second
                queue.add(v.first)
            }
        }
    }

    println(dist[0] + 1)
}