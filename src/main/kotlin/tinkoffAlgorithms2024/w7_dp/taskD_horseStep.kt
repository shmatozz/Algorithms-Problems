package tinkoffAlgorithms2024.w7_dp

fun inBoard(n: Int, m: Int, x: Int, y: Int) : Boolean {
    return x in 0 until n && y in 0 until m
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val dp = Array(n) { IntArray(m) { 0 } }
    dp[0][0] = 1

    val moves = arrayOf(Pair(2, 1), Pair(2, -1), Pair(1, 2), Pair(-1, 2))

    for (i in 0 until n + m) {
        var diag = i
        while (diag >= 0) {
            if (inBoard(n, m, i - diag, diag)) {
                for (move in moves) {
                    if (inBoard(n, m, i - diag + move.first, diag + move.second)) {
                        dp[i - diag + move.first][diag + move.second] += dp[i - diag][diag]
                    }
                }
            }
            diag--
        }
    }

    println(dp[n - 1][m - 1])
//    for (i in 0 until n) {
//        for (j in 0 until m) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }
}