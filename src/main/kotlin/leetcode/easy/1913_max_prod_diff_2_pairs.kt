package leetcode.easy

fun maxProductDifference(nums: IntArray): Int {
    var firstMin = Int.MAX_VALUE
    var secondMin = Int.MAX_VALUE
    var firstMax = 0
    var secondMax = 0

    for (i in nums) {
        if (i > firstMax) {
            secondMax = firstMax
            firstMax = i
        } else if (i > secondMax) {
            secondMax = i
        }

        if (i < firstMin) {
            secondMin = firstMin
            firstMin = i
        } else if (i < secondMin) {
            secondMin = i
        }
    }

    println("$firstMax $secondMax $firstMin $secondMin")
    return firstMax * secondMax - firstMin * secondMin
}

fun main() {
    println(maxProductDifference(intArrayOf(5,6,2,7,4)))
}