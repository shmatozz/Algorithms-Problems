package tinkoffAlgorithms2024.w11_solution_methods2

import kotlin.math.min

class Node(val parent: Int, val w: Int)

fun getPath(v: Int, tree: MutableList<Node>) : MutableList<Node> {
    val path = mutableListOf<Node>()
    path.add(Node(v, Int.MAX_VALUE))

    if (v == 0) return path

    var cur = tree[v - 1]
    while (cur.parent != 0) {
        path.add(Node(cur.parent, min(cur.w, path.last().w)))
        cur = tree[cur.parent - 1]
    }
    path.add(Node(0, min(cur.w, path.last().w)))

    return path
}

fun main() {
    val n = readln().toInt()
    val tree = mutableListOf<Node>()

    for (to in 1 until n) {
        val (x, y) = readln().split(' ').map { it.toInt() }
        tree.add(Node(x, y))
    }

    val m = readln().toInt()

    repeat(m) {
        val (u, v) = readln().split(' ').map { it.toInt() }

        val uPath = getPath(u, tree)
        val vPath = getPath(v, tree)

//        for (i in uPath) print("(${i.parent} ${i.w}) ")
//        println()
//
//        for (i in vPath) print("(${i.parent} ${i.w}) ")
//        println()

        var uPointer = uPath.size - 1
        var vPointer = vPath.size - 1

        while (uPointer >= 0 && vPointer >= 0) {
            if (uPath[uPointer].parent != vPath[vPointer].parent) {
                break
            }
            uPointer--
            vPointer--
        }
        println(min(uPath[uPointer + 1].w, vPath[vPointer + 1].w))
    }
}