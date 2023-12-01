package leetcode.easy

fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    var concatWord1 = ""
    var concatWord2 = ""

    for (seq in word1) concatWord1 += seq
    for (seq in word2) concatWord2 += seq

    return concatWord1 == concatWord2
}

fun main() {
    println(arrayStringsAreEqual(arrayOf("ab", "c", "de"), arrayOf("abc", "d", "e")))
}
