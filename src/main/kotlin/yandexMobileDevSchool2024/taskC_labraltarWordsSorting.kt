package yandexMobileDevSchool2024

fun main() {
    val n = readln().toInt()
    val words = Array(n) { "" }

    for (i in 0 until n) {
        words[i] = readln()
    }

    words.sortWith(compareByDescending<String> { it.count { c -> c in "aeiou" } }.thenBy { it.length })

    for (i in words) {
        println(i)
    }
}