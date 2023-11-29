package leetcode.medium

class Solution {
    operator fun CharSequence.times(count: Int): String {
        return repeat(count)
    }

    fun intToRoman(num: Int): String {
        var answer = ""

        answer += "M" * (num / 1000)
        answer += convertIntToRoman((num % 1000) / 100, "C", "D", "M")
        answer += convertIntToRoman((num % 100) / 10, "X", "L", "C")
        answer += convertIntToRoman(num % 10, "I", "V", "X")

        return answer
    }

    private fun convertIntToRoman(digit: Int, one: String, five: String, ten: String) : String{
        return if (digit <= 3) one * digit
        else if (digit == 4) one + five
        else if (digit == 5) five
        else if (digit in 6..8) five + one * (digit - 5)
        else one + ten
    }
}

fun main() {
    val solve = Solution()
    println(solve.intToRoman(994))
}