package tinkoffAlgorithms2024.w10_graphs2

import kotlin.math.max
import kotlin.math.min

class Info(val min: Int, val max: Int, val size: Int)

class DisjointSet(val n: Int) {
    private val parent = IntArray(n + 1) { it }
    private val rank = IntArray(n + 1)
    private val minArray = IntArray(n + 1) { it }
    private val maxArray = IntArray(n + 1) { it }
    private val sizeArray = IntArray(n + 1) { 1 }

    private fun find(x: Int): Int {
        if (parent[x] != x)
            parent[x] = find(parent[x])
        return parent[x]
    }

    fun get(x: Int) : Info {
        val y = find(x)
        return Info(minArray[y], maxArray[y], sizeArray[y])
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
                minArray[rootY] = min(minArray[rootX], minArray[rootY])
                maxArray[rootY] = max(maxArray[rootX], maxArray[rootY])
                sizeArray[rootY] += sizeArray[rootX]
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
                minArray[rootX] = min(minArray[rootX], minArray[rootY])
                maxArray[rootX] = max(maxArray[rootX], maxArray[rootY])
                sizeArray[rootX] += sizeArray[rootY]
            } else {
                parent[rootY] = rootX
                rank[rootX]++
                minArray[rootX] = min(minArray[rootX], minArray[rootY])
                maxArray[rootX] = max(maxArray[rootX], maxArray[rootY])
                sizeArray[rootX] += sizeArray[rootY]
            }
        }
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val disjointSet = DisjointSet(n)

    repeat(m) {
        val query = readln().split(' ')

        if (query[0] == "union") {
            disjointSet.union(query[1].toInt(), query[2].toInt())
        } else if (query[0] == "get") {
            val info = disjointSet.get(query[1].toInt())
            println("${info.min} ${info.max} ${info.size}")
        }
    }
}