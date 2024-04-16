import kotlin.math.max
import kotlin.math.min

class Node(var value: Long, var added: Long, var setted: Int) {
    override fun toString(): String {
        return "(${this.value}, ${this.added}, ${this.setted})"
    }
}

fun min(a: Node, b: Node): Long {
    if (a.value + a.added < b.value + b.added) {
        return a.value + a.added
    } else {
        return b.value + b.added
    }
}

fun push(tree: Array<Node>, cur: Int, size: Int) {
    if (tree[cur].setted != -1) {
        if (size != 1) {
            tree[cur * 2].setted = tree[cur].setted
            tree[cur * 2].added = 0

            tree[cur * 2 + 1].setted = tree[cur].setted
            tree[cur * 2 + 1].added = 0
        }

        tree[cur].value = tree[cur].setted.toLong() * size
        tree[cur].setted = -1
    }

    if (size != 1) {
        tree[cur * 2].added += tree[cur].added
        tree[cur * 2 + 1].added += tree[cur].added
    }

    tree[cur].value += tree[cur].added * size
    tree[cur].added = 0
}

fun add(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Int) {
    push(tree, cur, rightIndex - leftIndex + 1)

    if (start <= leftIndex && rightIndex <= end) {
        tree[cur].added += value.toLong()
        push(tree, cur, rightIndex - leftIndex + 1)
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add(tree, cur * 2, leftIndex, mid, start, min(end, mid), value)
    add(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end, value)

    tree[cur].value = tree[cur * 2].value + tree[cur * 2 + 1].value
}

fun set(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Int) {
    push(tree, cur, rightIndex - leftIndex + 1)

    if (start <= leftIndex && rightIndex <= end) {
        tree[cur].setted = value
        tree[cur].added = 0
        push(tree, cur, rightIndex - leftIndex + 1)
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    set(tree, cur * 2, leftIndex, mid, start, min(end, mid), value)
    set(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end, value)

    tree[cur].value = tree[cur * 2].value + tree[cur * 2 + 1].value
}

fun get(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int): Long {
    push(tree, cur, rightIndex - leftIndex + 1)

    if (start > end) {
        return 0
    }

    if (start <= leftIndex && rightIndex <= end) {
        return tree[cur].value
    }

    val mid = (leftIndex + rightIndex) / 2
    return get(tree, cur * 2, leftIndex, mid, start, min(end, mid)) +
            get(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end)
}

fun printTree(tree: Array<Node>) {
    for (i in tree) {
        print("$i ")
    }
    println()
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }

    val tree = Array(n * 4) { Node(0, 0, -1) }

    repeat(m) {
        val request = readln().split(' ')

        if (request[0] == "1") {
            set(tree, 1, 0, n - 1, request[1].toInt(), request[2].toInt() - 1, request[3].toInt())
//            println("after SET:")
//            printTree(tree)
        } else if (request[0] == "2") {
            add(tree, 1, 0, n - 1, request[1].toInt(), request[2].toInt() - 1, request[3].toInt())
//            println("after ADD:")
//            printTree(tree)
        } else if (request[0] == "3") {
            println(get(tree, 1, 0, n - 1, request[1].toInt(), request[2].toInt() - 1))
//            println("after GET:")
//            printTree(tree)
        }
    }
}
