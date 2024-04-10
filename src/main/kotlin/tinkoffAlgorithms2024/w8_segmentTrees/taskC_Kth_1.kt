package tinkoffAlgorithms2024.w8_segmentTrees

fun buildEmptyTree(tree: IntArray, array: IntArray, cur: Int, leftIndex: Int, rightIndex: Int) {
    if (leftIndex == rightIndex) {
        tree[cur] = array[leftIndex]
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    buildEmptyTree(tree, array, cur * 2, leftIndex, mid)
    buildEmptyTree(tree, array, cur * 2 + 1, mid + 1, rightIndex)

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1]
}

fun add(tree: IntArray, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int) {
    if (start == leftIndex && rightIndex == end) {
        tree[cur] = if (tree[cur] == 1) {
            0
        } else {
            1
        }
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add(tree, cur * 2, leftIndex, mid, start, end)
    add(tree, cur * 2 + 1, mid + 1, rightIndex, start, end)

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1]
}

fun get(tree: IntArray, cur: Int, leftIndex: Int, rightIndex: Int, k: Int): Int {
    if (leftIndex == rightIndex) {
        return leftIndex
    }

    val mid = (leftIndex + rightIndex) / 2
    if (k < tree[cur * 2]) {
        return get(tree, cur * 2, leftIndex, mid, k)
    } else {
        return get(tree, cur * 2 + 1, mid + 1, rightIndex, k - tree[cur * 2])
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val array = readln().split(' ').map { it.toInt() }.toIntArray()

    val tree = IntArray(n * 4)
    buildEmptyTree(tree, array, 1, 0, n - 1)

    repeat(m) {
        val (op, first) = readln().split(' ').map { it.toInt() }

        if (op == 1) {
            add(tree, 1, 0, n - 1, first, first)
        } else if (op == 2) {
            println(get(tree, 1, 0, n - 1, first))
        }
    }
}
