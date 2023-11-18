package easy

fun printGraph(graph: MutableMap<Int, MutableSet<Int>>) {
    for (v in graph.keys) {
        print("$v: ")
        for (i in graph[v]!!) {
            print("$i ")
        }
        println()
    }
}

fun dfs(graph: MutableMap<Int, MutableSet<Int>>, v: Int, visited: BooleanArray) {
    visited[v] = true
    for (next in graph.getOrDefault(v, mutableSetOf())) {
        if (!visited[next]) {
            dfs(graph, next, visited)
        }
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val graph: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    // reading and build graph
    for (i in 0 until m) {
        val (from, to) = readln().split(' ').map { it.toInt() }
        graph.putIfAbsent(from, mutableSetOf())
        graph.putIfAbsent(to, mutableSetOf())
        graph[from]?.apply {
            add(to)
        }
        graph[to]?.apply {
            add(from)
        }
    }

    // printGraph(graph)
    val visited = BooleanArray(n + 1) { false }
    dfs(graph, 1, visited)
    // for (i in visited) println(i)

    val answer = mutableListOf<Int>()
    for (i in 1 until visited.size) {
        if (visited[i]) {
            answer.add(i)
        }
    }

    println(answer.size)
    for (v in answer) print("$v ")
}