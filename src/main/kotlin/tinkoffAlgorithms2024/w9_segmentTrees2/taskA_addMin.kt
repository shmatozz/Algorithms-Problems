package tinkoffAlgorithms2024.w9_segmentTrees2

import kotlin.math.max
import kotlin.math.min

class Node(var value: Long, var added: Long) {
    override fun toString(): String {
        return "(${this.value}, ${this.added})"
    }
}

fun min(a: Node, b: Node): Long {
    if (a.value + a.added < b.value + b.added) {
        return a.value + a.added
    } else {
        return b.value + b.added
    }
}

fun add(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Int) {
    if (start <= leftIndex && rightIndex <= end) {
        tree[cur].added += value.toLong()
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add(tree, cur * 2, leftIndex, mid, start, min(end, mid), value)
    add(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end, value)

    tree[cur].value = min(tree[cur * 2], tree[cur * 2 + 1])
}

fun get(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int): Long {
    if (start > end) {
        return Long.MAX_VALUE
    }

    if (start <= leftIndex && rightIndex <= end) {
        return tree[cur].value + tree[cur].added
    }

    val mid = (leftIndex + rightIndex) / 2
    return tree[cur].added + min(
        get(tree, cur * 2, leftIndex, mid, start, min(end, mid)) ,
        get(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end)
    )
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val tree = Array(n * 4) { Node(0, 0) }

    repeat(m) {
        val request = readln().split(' ')

        if (request[0] == "1") {
            add(tree, 1, 0, n - 1, request[1].toInt(), request[2].toInt() - 1, request[3].toInt())
//            for (i in tree) {
//                print("$i ")
//            }
//            println()
        } else if (request[0] == "2") {
            println(get(tree, 1, 0, n - 1, request[1].toInt(), request[2].toInt() - 1))
        }
    }
}
