package leetcode.easy

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x / 10 == 0) return true

        var current = x
        var reversedX = x % 10
        current /= 10

        while (current != 0) {
            reversedX *= 10
            reversedX += current % 10
            current /= 10
        }

        return reversedX == x
    }
}

fun main() {
    val a = Solution()
    println(a.isPalindrome(1000000001))
}