package leetcode.easy

fun makeEqual(words: Array<String>): Boolean {
    if (words.size == 1) {
        return true
    }

    val charCounter = IntArray(26) { 0 }

    for (word in words) {
        for (char in word) {
            charCounter[char - 'a']++
        }
    }

    return charCounter.all { it % words.size == 0 }
}

fun main() {
    println(makeEqual(arrayOf("abc", "aabc", "bc")))
    println(makeEqual(arrayOf("ab", "a")))
    println(makeEqual(arrayOf("caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c")))
    println(makeEqual(arrayOf("aaaaaaaaaaaaaaaaa","aaaaa","aaaaaa","aaaaaaaaa","a","aaa","aaaa","bbbbbbbbbbbbbbbbbbbbbbb","bb","b","bb","bb","ccccccccccccccccccccccccccccccccccccccc","c","ccccc")))
}