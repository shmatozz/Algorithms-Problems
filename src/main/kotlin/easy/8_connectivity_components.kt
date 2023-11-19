package easy

fun dfs(graph: Array<MutableSet<Int>>, start: Int, inComponent: IntArray) {
    val stack = mutableListOf(start)
    inComponent[start] = inComponent[0]

    while (stack.isNotEmpty()) {
        val current = stack.removeAt(stack.size - 1)
        for (next in graph[current]) {
            if (inComponent[next] == 0) {
                stack.add(next)
                inComponent[next] = inComponent[0]
            }
        }
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val graph: Array<MutableSet<Int>> = Array(n + 1) { mutableSetOf() }
    // reading and build graph
    for (i in 0 until m) {
        val (from, to) = readln().split(' ').map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }

    // printGraph(graph)
    val inComponent = IntArray(n + 1) { 0 }
    inComponent[0] = 1
    while (inComponent.any { it == 0 }) {
        dfs(graph, inComponent.indexOf(0), inComponent)
        inComponent[0]++
    }

    println(inComponent[0] - 1)
    for (i in 1 until inComponent[0]) {
        println(inComponent.count { it == i })
        println(inComponent.indices.filter { inComponent[it] == i }.joinToString(" "))
    }
}