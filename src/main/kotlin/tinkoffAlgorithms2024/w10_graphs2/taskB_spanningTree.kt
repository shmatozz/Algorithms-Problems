package tinkoffAlgorithms2024.w10_graphs2

class Edge(val from: Int, val to: Int, val w: Int)

fun find(visited: IntArray, u: Int): Int {
    if (visited[u] != u)
        visited[u] = find(visited, visited[u])
    return visited[u]
}

fun union(visited: IntArray, u: Int, v: Int) {
    val pu = find(visited, u)
    val pv = find(visited, v)
    if (pu != pv)
        visited[pu] = pv
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val edges = mutableListOf<Edge>()

    repeat(m) {
        val (from, to, w) = readln().split(' ').map { it.toInt() }
        edges.add(Edge(from, to, w))
    }

    edges.sortBy { it.w }

    val visited = IntArray(n + 1) { it }

    var treeWeight = 0L
    for (edge in edges) {
        if (find(visited, edge.from) != find(visited, edge.to)) {
            union(visited, edge.from, edge.to)
            treeWeight += edge.w
        }
    }

    println(treeWeight)
}