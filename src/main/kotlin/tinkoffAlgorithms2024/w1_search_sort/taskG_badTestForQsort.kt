package tinkoffAlgorithms2024.w1_search_sort

fun main() {
    val n = readln().toInt()
    val ans = IntArray(n) { it + 1 }

    for (i in 2 until n) {
        ans[i] += ans[i / 2]
        ans[i / 2] = ans[i] - ans[i / 2]
        ans[i] -= ans[i / 2]
    }

    for (i in ans) print("$i ")
}