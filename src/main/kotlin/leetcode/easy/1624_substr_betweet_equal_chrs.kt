package leetcode.easy

import kotlin.math.max

fun maxLengthBetweenEqualCharacters(s: String): Int {
    var answer = -1
    val lastTimeInLetters = IntArray(26) { -1 }

    for (i in s.indices) {
        if (lastTimeInLetters[s[i].code - 97] == -1) {
            lastTimeInLetters[s[i].code - 97] = i
        } else {
            answer = max(answer, i - lastTimeInLetters[s[i].code - 97] - 1)
        }
    }

    return answer
}

fun main() {
    println(maxLengthBetweenEqualCharacters("aa"))
    println(maxLengthBetweenEqualCharacters("abca"))
    println(maxLengthBetweenEqualCharacters("asdfgh"))
}