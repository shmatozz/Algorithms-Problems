package tinkoffAlgorithms2024.w3_trees

import kotlin.math.abs
import kotlin.math.max

fun calcHeights(v: Int, heights: IntArray, tree: MutableList<Pair<Int, Int>>) {
    if (v == -1) {
        return
    }

    calcHeights(tree[v].first, heights, tree)
    calcHeights(tree[v].second, heights, tree)
    var left = 0
    var right = 0
    if (tree[v].first != -1) {
        left = heights[tree[v].first]
    }
    if (tree[v].second != -1) {
        right = heights[tree[v].second]
    }
    heights[v] = max(left, right) + 1
}

fun max(r: Int, tree: MutableList<Pair<Int, Int>>) : Int {
    var cur = tree[r].first
    if (cur == -1) {
        return r
    }
    while (true) {
        if (tree[cur].second == -1) {
            return cur
        }
        cur = tree[cur].second
    }
}

fun min(r: Int, tree: MutableList<Pair<Int, Int>>) : Int {
    var cur = tree[r].second
    if (cur == -1) {
        return r
    }
    while (true) {
        if (tree[cur].first == -1) {
            return cur
        }
        cur = tree[cur].first
    }
}

fun isAVL(r: Int, tree: MutableList<Pair<Int, Int>>, heights: IntArray) : Int {
    if (r == -1) {
        return 1
    }

    var left = 0
    var right = 0
    if (tree[r].first != -1) {
        left = heights[tree[r].first]
    }
    if (tree[r].second != -1) {
        right = heights[tree[r].second]
    }

    return if (
        isAVL(tree[r].first, tree, heights) == 1 &&
        isAVL(tree[r].second, tree, heights) == 1 &&
        abs(left - right) <= 1 &&
        max(r, tree) <= r &&
        min(r, tree) >= r
    ) {
        1
    } else {
        0
    }
}

fun main() {
    val (n, r) = readln().split(' ').map { it.toInt() }
    val tree = mutableListOf<Pair<Int, Int>>()
    val heights = IntArray(n) { 0 }

    repeat(n) {
        val (left, right) = readln().split(' ').map { it.toInt() }
        tree.add(Pair(left, right))
    }

    calcHeights(r, heights, tree)
    println(isAVL(r, tree, heights))
}