package yandexMobileDevSchool2024

// TL
fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }
    val string = readln()

    val dp = Array(n + 1) { -1 }
    val startIndex = Array(n + 1) { -1 }

    dp[0] = 0

    for (i in l..n) {
        for (j in l..r) {
            if (i - j >= 0 && dp[i - j] != -1) {
                val curSubStr = string.substring(i - j, i)
                val curSum = curSubStr.max() - curSubStr.min()
                if (dp[i] == -1 || dp[i - j] + curSum >= dp[i]) {
                    dp[i] = dp[i - j] + curSum
                    startIndex[i] = i - j
                }
            }
        }
    }

//    for (i in dp) print("$i ")
//    println()
//    for (i in startIndex) print("$i ")
//    println()

    if (dp[n] == -1) {
        println("NO SOLUTION")
    } else {
        val words = mutableListOf<String>()
        var idx = n

        while (idx > 0) {
            words.add(string.substring(startIndex[idx], idx))
            idx = startIndex[idx]
        }

        println(dp[n])
        println(words.size)
        for (i in words.size - 1 downTo  0) {
            println(words[i])
        }
    }
}