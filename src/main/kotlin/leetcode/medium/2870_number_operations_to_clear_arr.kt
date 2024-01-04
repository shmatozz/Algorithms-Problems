package leetcode.medium

fun minOperations(nums: IntArray): Int {
    var operationsCount = 0

    val numbersMap = mutableMapOf<Int, Int>()

    for (num in nums) {
        numbersMap[num] = numbersMap.getOrDefault(num, 0) + 1
    }

    for (num in numbersMap.keys) {
        val curNumCount = numbersMap.getOrDefault(num, 0)
        if (curNumCount == 1) {
            return -1
        } else if (curNumCount == 2 || curNumCount == 3) {
            operationsCount += 1
        } else if (curNumCount % 3 == 1 || curNumCount % 3 == 2) {
            operationsCount += (curNumCount / 3) + 1
        } else if (curNumCount % 3 == 0) {
            operationsCount += curNumCount / 3
        }
    }

    return operationsCount
}

fun main() {
    println(minOperations(intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4)))
    println(minOperations(intArrayOf(2, 1, 2, 2, 3, 3)))
}