package tinkoffAlgorithms2024.w1_search_sort

import kotlin.math.abs

fun getTableDiv(n: Int, m: Int) : Pair<Char, Int> {
    var dim: Char = 'N'
    var split = -1

    var left = 1
    var right = m
    var mid = (left + right) / 2
    var minDiff = 1000000000000000.0
    // horizontal search
    while (left < right) {
        mid = (left + right) / 2
        val leftSum = (((1 + mid) / 2.0 * mid) +
                ((((n - 1) * m + 1) + ((n - 1) * m + mid)) / 2.0 * mid)) /
                2.0 * n
        val rightSum = (((mid + 1 + m) / 2.0 * (m - mid)) +
                ((((n - 1) * m + mid + 1) + ((n - 1) * m + m)) / 2.0 * (m - mid))) /
                2.0 * n

        val diff = leftSum - rightSum
        if (abs(diff) < minDiff) {
            minDiff = abs(diff)
            split = mid + 1
            dim = 'V'
        }
        if (diff == 0.0) {
            return Pair('V', mid + 1)
        } else if (diff < 0) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    // vertical search
    left = 1
    right = n
    while (left < right) {
        mid = (left + right) / 2
        val leftSum = (((1 + m) / 2.0 * m) +
                ((((mid - 1) * m + 1) + ((mid - 1) * m + m)) / 2.0 * m)) /
                2.0 * mid
        val rightSum = ((((mid * m + 1) + (mid * m + m)) / 2.0 * m) +
                ((((n - 1) * m + 1) + ((n - 1) * m + m)) / 2.0 * m)) /
                2.0 * (n - mid)

        val diff = leftSum - rightSum
        if (abs(diff) < minDiff) {
            minDiff = abs(diff)
            split = mid + 1
            dim = 'H'
        }
        if (diff == 0.0) {
            return Pair('H', mid + 1)
        } else if (diff < 0) {
            left = mid + 1
        } else {
            right = mid
        }
    }


    return Pair(dim, split)
}

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (n, m) = readln().split(' ').map { it.toInt() }

        val ans = getTableDiv(n, m)
        println("${ans.first} ${ans.second}")
    }
}