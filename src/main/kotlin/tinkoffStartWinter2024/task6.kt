package tinkoffStartWinter2024

import kotlin.math.min

class Node (var max: Int = 0,
            var maxInd: Int = 0,
            var left: Node? = null,
            var right: Node? = null,
            var leftIndex: Int = 0,
            var rightIndex: Int = 0)

fun buildEmptyTree(array: IntArray, leftIndex: Int, rightIndex: Int): Node {
    // if reached half interval [leftIndex, leftIndex + 1)
    if (leftIndex + 1 == rightIndex) {
        return Node(array[leftIndex], leftIndex, null, null, leftIndex, rightIndex)
    }

    val mid = (leftIndex + rightIndex) / 2
    val left = buildEmptyTree(array, leftIndex, mid)
    val right = buildEmptyTree(array, mid, rightIndex)

    val max: Int
    val maxInd: Int
    if (left.max > right.max) {
        max = left.max
        maxInd = left.maxInd
    } else {
        max = right.max
        maxInd = right.maxInd
    }

    return Node(max, maxInd, left, right, left.leftIndex, right.rightIndex)
}

fun getAnswer(node: Node?, start: Int, end: Int): Pair<Int, Int> {
    // if node == null -> lower level reached
    if (node != null) {
        if (start <= node.leftIndex && node.rightIndex <= end) {
            return Pair(node.max, node.maxInd)
        }

        if (node.rightIndex <= start || end < node.leftIndex) {
            return Pair(-1, -1)
        }

        val maxLeft = getAnswer(node.left, start, end)
        val maxRight = getAnswer(node.right, start, end)

        return if (maxLeft.first > maxRight.first) {
            maxLeft
        } else {
            maxRight
        }
    }
    return Pair(-1, -1)
}

fun add(node: Node, start: Int, end: Int, value: Int) : Node {
    if (start <= node.leftIndex && node.rightIndex <= end) {
        return Node(node.max + value, node.maxInd, node.left, node.right, node.leftIndex, node.rightIndex)
    }

    if (node.rightIndex <= start || end <= node.leftIndex) {
        return node
    }

    val new = Node(node.max, node.maxInd, node.left, node.right, node.leftIndex, node.rightIndex)

    new.left = add(new.left!!, start, end, value)
    new.right = add(new.right!!, start, end, value)
    if (new.left!!.max > new.right!!.max) {
        new.max = new.left!!.max
        new.maxInd = new.left!!.maxInd
    } else {
        new.max = new.right!!.max
        new.maxInd = new.right!!.maxInd
    }

    return new
}

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val array = readln().split(" ").map { it.toInt() }.toIntArray()
    var tree = buildEmptyTree(array, 0, array.size)

    repeat(q) {
        val query = readln().split(" ")
        if (query[0] == "+") {
            tree = add(tree, query[1].toInt() - 1, query[2].toInt(), query[3].toInt())
        } else if (query[0] == "?") {
            val max = getAnswer(tree, query[1].toInt() - 1, query[2].toInt())
            println(min(max.first, query[3].toInt() * (max.second + 1) + query[4].toInt()))
        }
    }
}