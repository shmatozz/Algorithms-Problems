package deepDiveExam

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: Array<Boolean>): Array<Boolean> {
    for (screen in graph[v]) {
        if (!visited[screen]) {
            visited[screen] = true
            dfs(graph, screen, visited)
        }
    }
    return visited
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val screens = readln().split(' ').toTypedArray()
    val screensNumbers = mutableMapOf<String, Int>()
    val mainScreen = readln()

    for (i in 0 until n) {
        screensNumbers[screens[i]] = i
    }

    val graph = Array(n) { mutableListOf<Int>() }

    for (i in 0 until m) {
        val (from, to) = readln().split(' ')
        graph[screensNumbers[from]!!].add(screensNumbers[to]!!)
    }

    val visited = Array(n) { false }
    val beginIndex = screensNumbers[mainScreen]!!

    visited[beginIndex] = true

    dfs(graph, beginIndex, visited)

    println(visited.count { !it })
}