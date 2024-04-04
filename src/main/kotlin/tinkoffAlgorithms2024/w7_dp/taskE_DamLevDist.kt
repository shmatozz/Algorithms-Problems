package tinkoffAlgorithms2024.w7_dp

import kotlin.math.min

/*
def dist(str1, str2):
    m = len(str1)
    n = len(str2)

    if m == 0:
        if n == 0:
            return 0
        else:
            return n
    elif n == 0:
        return m

    operations = []
    for i in range(m + 1):
        a = [0] * (n + 1)
        operations.append(a)

    for i in range(m + 1):
        operations[i][0] = i

    for i in range(n + 1):
        operations[0][i] = i

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if str1[i - 1] == str2[j - 1]:
                equal = 0
            else:
                equal = 1
            operations[i][j] = min(operations[i - 1][j] + 1, operations[i][j - 1] + 1, operations[i - 1][j - 1] + equal)
            if i > 1 and j > 1 and str1[i - 1] == str2[j - 2] and str1[i - 2] == str2[j - 1]:
                operations[i][j] = min(operations[i][j], operations[i - 2][j - 2] + equal)

    return operations[-1][-1]


main_string = input()
word = input()

print(dist(main_string, word))
 */

fun main() {
    val str1 = readln()
    val str2 = readln()
    val n = str1.length
    val m = str2.length
    val dp = Array(n + 1) { IntArray(m + 1) { 0 } }

    for (i in 0 until n + 1) {
        dp[i][0] = i
    }
    for (i in 0 until m + 1) {
        dp[0][i] = i
    }

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            val equal = if (str1[i - 1] == str2[j - 1]) {
                0
            } else {
                1
            }
            dp[i][j] = min(dp[i - 1][j] + 1, min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + equal))
            if (i > 1 && j > 1 && str1[i - 1] == str2[j - 2] && str1[i - 2] == str2[j - 1]) {
                dp[i][j] = min(dp[i][j], dp[i - 2][j - 2] + equal)
            }
        }
    }

    println(dp[n][m])

}
