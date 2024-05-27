package leetcode.easy

fun specialArray(nums: IntArray): Int {
    val sortedNums = nums.sorted()

    var left = 0
    var right = 101
    var mid = 0
    while (left + 1 < right) {
        println("$left $right")
        mid = (left + right) / 2

        val count = countState(mid, sortedNums)
        if (count == mid) {
            return mid
        } else if (count < mid) {
            right = mid
        } else {
            left = mid
        }
    }

    return -1
}

fun countState(num: Int, sortedNums: List<Int>) : Int {
    var count = 0

    for (i in sortedNums) {
        if (i >= num) {
            count++
        }
    }

    return count
}

fun main() {
    println(specialArray(intArrayOf(3, 5)))
}