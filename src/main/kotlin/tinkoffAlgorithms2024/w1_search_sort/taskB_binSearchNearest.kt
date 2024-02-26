package tinkoffAlgorithms2024.w1_search_sort

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val array = readln().split(' ').map { it.toInt() }.toIntArray()
    val requests = readln().split(' ').map { it.toInt() }.toIntArray()

    for (req in requests) {
        var finded = false
        var left = 0
        var right = array.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (array[mid] == req) {
                finded = true
                break
            } else if (array[mid] < req) {
                left = mid + 1
            } else if (array[mid] > req) {
                right = mid - 1
            }
        }

        if (finded) {
            println(array[(left + right) / 2])
        } else {
            right = max(right, 0)
            left = min(left, array.size - 1)
            if (abs(array[right] - req) <= abs(array[left] - req)) {
                println(array[right])
            } else {
                println(array[left])
            }
        }
    }
}