package tinkoffAlgorithms2024.w1_search_sort

fun main() {
    val n = readln().toInt()
    val str = readln()
    val letterCount = IntArray(26) { 0 }

    for (ch in str) {
        letterCount[ch - 'A']++
    }

    var ans = ""
    var maxOdd = -1

    for (i in letterCount.indices) {
        if (letterCount[i] % 2 == 1) {
            if (maxOdd == -1 || letterCount[i] > letterCount[maxOdd]) {
                maxOdd = i
            }
        }
    }

    for (i in letterCount.indices) {
        if (letterCount[i] > 0) {
            ans += (i + 'A'.code).toChar().toString().repeat(letterCount[i] / 2)
        }
    }

    if (maxOdd != -1) {
        print("$ans${(maxOdd + 'A'.code). toChar()}${ans.reversed()}")
    } else {
        print("$ans${ans.reversed()}")
    }
}