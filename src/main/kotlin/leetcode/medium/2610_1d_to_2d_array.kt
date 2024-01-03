package leetcode.medium

fun findMatrix(nums: IntArray): List<List<Int>> {
    val numbersMap = mutableMapOf<Int, Int>()

    for (i in nums) {
        if (numbersMap.getOrDefault(i, -1) == -1) {
            numbersMap[i] = nums.count{ it == i }
        }
    }

    val converted2dArray: MutableList<MutableList<Int>> = mutableListOf()

    for (i in numbersMap.keys) {
        val curCount: Int = numbersMap.getOrDefault(i, 0)
        for (j in 1 .. curCount) {
            if (converted2dArray.size < j) {
                converted2dArray.add(mutableListOf(i))
            } else {
                converted2dArray[j - 1].add(i)
            }
        }
    }

    return converted2dArray
}

fun main() {
    println(findMatrix(intArrayOf(1, 3, 4, 1, 2, 3, 1)))
    println(findMatrix(intArrayOf(1, 2, 3, 4)))
}