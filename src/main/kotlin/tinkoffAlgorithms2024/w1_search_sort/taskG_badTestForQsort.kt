package tinkoffAlgorithms2024.w1_search_sort

fun main() {
    val n = readln().toInt()

    for (i in (n - n % 2) downTo 1 step 2) print("$i ")
    for (i in 1..n step 2) print("$i ")
}