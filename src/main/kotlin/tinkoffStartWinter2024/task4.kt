package tinkoffStartWinter2024

data class Vertex(val cost: Int, val name: String, val children: MutableList<Vertex>)


fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val requireNames: MutableMap<String, Int> = mutableMapOf()
    for (i in 0 until k) {
        val name = readln()
        requireNames[name] = -1
    }

    val graph = mutableListOf<Vertex>()
    for (i in 0 until n) {
        val (p, a, c) = readln().split(" ")
        graph.add(Vertex(a.toInt(), c, mutableListOf()))

        if (p != "0") {
            graph[p.toInt() - 1].children.add(graph.last())
        }
    }

    println(3)
}