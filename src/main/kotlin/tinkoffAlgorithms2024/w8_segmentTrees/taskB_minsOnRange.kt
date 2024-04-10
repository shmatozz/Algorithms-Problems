package tinkoffAlgorithms2024.w8_segmentTrees

data class Node(var value: Long, var countMins: Int)

fun buildEmptyTree(tree: Array<Node>, array: LongArray, cur: Int, leftIndex: Int, rightIndex: Int) {
    if (leftIndex == rightIndex) {
        tree[cur] = Node(array[leftIndex], 1)
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    buildEmptyTree(tree, array, cur * 2, leftIndex, mid)
    buildEmptyTree(tree, array, cur * 2 + 1, mid + 1, rightIndex)

    if (tree[cur * 2].value < tree[cur * 2 + 1].value) {
        tree[cur].value = tree[cur * 2].value
        tree[cur].countMins = tree[cur * 2].countMins
    } else if (tree[cur * 2].value == tree[cur * 2 + 1].value) {
        tree[cur].value = tree[cur * 2].value
        tree[cur].countMins = tree[cur * 2].countMins + tree[cur * 2 + 1].countMins
    } else {
        tree[cur].value = tree[cur * 2 + 1].value
        tree[cur].countMins = tree[cur * 2 + 1].countMins
    }
}

fun add(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Long) {
    if (start == leftIndex && rightIndex == end) {
        tree[cur].value = value
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add(tree, cur * 2, leftIndex, mid, start, end, value)
    add(tree, cur * 2 + 1, mid + 1, rightIndex, start, end, value)

    if (tree[cur * 2].value < tree[cur * 2 + 1].value) {
        tree[cur].value = tree[cur * 2].value
        tree[cur].countMins = tree[cur * 2].countMins
    } else if (tree[cur * 2].value == tree[cur * 2 + 1].value) {
        tree[cur].value = tree[cur * 2].value
        tree[cur].countMins = tree[cur * 2].countMins + tree[cur * 2 + 1].countMins
    } else {
        tree[cur].value = tree[cur * 2 + 1].value
        tree[cur].countMins = tree[cur * 2 + 1].countMins
    }
}

fun get(tree: Array<Node>, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int): Node {
    if (start > end) {
        return Node(Long.MAX_VALUE, 0)
    }

    if (start <= leftIndex && rightIndex <= end) {
        return tree[cur]
    }

    val mid = (leftIndex + rightIndex) / 2
    val left = get(tree, cur * 2, leftIndex, mid, start, minOf(end, mid))
    val right = get(tree, cur * 2 + 1, mid + 1, rightIndex, maxOf(start, mid + 1), end)
    if (left.value < right.value) {
        return left
    } else if (left.value == right.value) {
        return Node(left.value, left.countMins + right.countMins)
    } else {
        return right
    }
}

fun min(a: Node, b: Node): Node {
    if (a.value < b.value) {
        return a
    } else {
        return b
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val array = readln().split(' ').map { it.toLong() }.toLongArray()

    val tree = Array<Node>(n * 4) { Node(0, 0) }
    buildEmptyTree(tree, array, 1, 0, n - 1)

    repeat(m) {
        val (op, first, second) = readln().split(' ').map { it.toInt() }

        if (op == 1) {
            add(tree, 1, 0, n - 1, first, first, second.toLong())
        } else if (op == 2) {
            val result = get(tree, 1, 0, n - 1, first, second - 1)
            println("${result.value} ${result.countMins}")
        }
    }
}
