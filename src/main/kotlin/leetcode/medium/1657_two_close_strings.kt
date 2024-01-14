package leetcode.medium

fun closeStrings(word1: String, word2: String): Boolean {
    val word1Counter = IntArray(26) { 0 }
    val word2Counter = IntArray(26) { 0 }

    for (ch in word1) word1Counter[ch - 'a']++
    for (ch in word2) word2Counter[ch - 'a']++

    for (i in 0 until 26) {
        if ((word1Counter[i] == 0 && word2Counter[i] != 0) ||
            (word1Counter[i] != 0 && word2Counter[i] == 0) ) {
            return false
        }
    }

    word1Counter.sort()
    word2Counter.sort()

    for (i in 0 until 26) {
        if (word1Counter[i] != word2Counter[i]) {
            return false
        }
    }

    return true
}

fun main() {
    println(closeStrings(word1 = "abc", word2 = "bca"))
    println(closeStrings(word1 = "a", word2 = "aa"))
    println(closeStrings(word1 = "cabbba", word2 = "abbccc"))
}