package tinkoffAlgorithms2024.w6_graphs

import java.util.Stack

fun dfs(graph: Array<MutableSet<Int>>, start: Int, inComponent: IntArray) : MutableList<Int> {
    val stack = Stack<Int>()
    stack.push(start)
    val component = mutableListOf(start)
    inComponent[start] = inComponent[0]

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        for (next in graph[current]) {
            if (inComponent[next] == 0) {
                stack.push(next)
                component.add(next)
                inComponent[next] = inComponent[0]
            }
        }
    }
    return component
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
    val components = mutableListOf<MutableList<Int>>()
    inComponent[0] = 1
    for (v in 1 until graph.size) {
        if (inComponent[v] == 0) {
            components.add(dfs(graph, v, inComponent))
        }
    }

    println(components.size)
    for (i in components) {
        println(i.size)
        println(i.sorted().joinToString(" "))
    }
}