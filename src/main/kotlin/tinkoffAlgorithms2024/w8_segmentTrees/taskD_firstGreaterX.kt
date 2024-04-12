package tinkoffAlgorithms2024.w8_segmentTrees

import kotlin.math.max
import kotlin.math.min

fun buildTree(tree: IntArray, array: IntArray, cur: Int, leftIndex: Int, rightIndex: Int) {
    if (leftIndex == rightIndex) {
        tree[cur] = array[leftIndex]
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    buildTree(tree, array, cur * 2, leftIndex, mid)
    buildTree(tree, array, cur * 2 + 1, mid + 1, rightIndex)

    tree[cur] = max(tree[cur * 2], tree[cur * 2 + 1])
}

fun add1(tree: IntArray, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Int) {
    if (start == leftIndex && rightIndex == end) {
        tree[cur] = value
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add1(tree, cur * 2, leftIndex, mid, start, end, value)
    add1(tree, cur * 2 + 1, mid + 1, rightIndex, start, end, value)

    tree[cur] = max(tree[cur * 2], tree[cur * 2 + 1])
}

fun get1(tree: IntArray, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, x: Int): Int {
    if (start > end) {
        return Int.MAX_VALUE
    }

    if (leftIndex == rightIndex) {
        return if (tree[cur] >= x) {
            leftIndex
        } else {
            Int.MAX_VALUE
        }
    }

    val mid = (leftIndex + rightIndex) / 2
    if (leftIndex < start) {
        return min(
            get1(tree, cur * 2, leftIndex, mid, start, min(end, mid), x),
            get1(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end, x)
        )
    }

    return if (tree[cur * 2] >= x) {
        get1(tree, cur * 2, leftIndex, mid, start, min(end, mid), x)
    } else {
        get1(tree, cur * 2 + 1, mid + 1, rightIndex, max(start, mid + 1), end, x)
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val array = readln().split(' ').map { it.toInt() }.toIntArray()

    val tree = IntArray(n * 4)
    buildTree(tree, array, 1, 0, n - 1)

    repeat(m) {
        val (op, first, second) = readln().split(' ').map { it.toInt() }

        if (op == 1) {
            add1(tree, 1, 0, n - 1, first, first, second)
        } else if (op == 2) {
            val result = get1(tree, 1, 0, n - 1, second, n - 1, first)
            println(if (result == Int.MAX_VALUE) -1 else result)
        }
    }
}