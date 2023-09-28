package internWeekOfferExam

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val field = Array(n) { String() }

    for (i in 0 until n) {
        field[i] = readln()
    }

    val dynamicUp = Array(n) { Array(m) { 0 } }
    val dynamicDown = Array(n) { Array(m) { 0 } }
    val dynamicRight = Array(n) { Array(m) { 0 } }
    val dynamicLeft = Array(n) { Array(m) { 0 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (j == 0 || field[j][i] == 'W') {
                continue
            } else if (field[j - 1][i] == 'B') {
                dynamicUp[j][i] = dynamicUp[j - 1][i] + 1
            } else if (field[j][i] == '.') {
                dynamicUp[j][i] = dynamicUp[j - 1][i]
            }
        }
    }

    for (i in 0 until m) {
        for (j in n - 1 downTo 0) {
            if (j == n - 1 || field[j][i] == 'W') {
                continue
            } else if (field[j + 1][i] == 'B') {
                dynamicDown[j][i] = dynamicDown[j + 1][i] + 1
            } else if (field[j][i] == '.') {
                dynamicDown[j][i] = dynamicDown[j + 1][i]
            }
        }
    }

    for (i in 0 until n) {
        for (j in m - 1 downTo 0) {
            if (j == m - 1 || field[i][j] == 'W') {
                continue
            } else if (field[i][j + 1] == 'B') {
                dynamicRight[i][j] = dynamicRight[i][j + 1] + 1
            } else if (field[i][j] == '.') {
                dynamicRight[i][j] = dynamicRight[i][j + 1]
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (j == 0 || field[i][j] == 'W') {
                continue
            } else if (field[i][j - 1] == 'B') {
                dynamicLeft[i][j] = dynamicLeft[i][j - 1] + 1
            } else if (field[i][j] == '.') {
                dynamicLeft[i][j] = dynamicLeft[i][j - 1]
            }
        }
    }

    val total = Array(n) { Array(m) { 0 } }
    val maxAns = arrayOf(-1, -1, -1) // first = i, second = j, third = maximum answer

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (field[i][j] == '.') {
                total[i][j] = dynamicUp[i][j] + dynamicDown[i][j] + dynamicRight[i][j] + dynamicLeft[i][j]
                if (total[i][j] > maxAns[2]) {
                    maxAns[0] = i + 1
                    maxAns[1] = j + 1
                    maxAns[2] = total[i][j]
                }
            }
        }
    }

    println("${maxAns[0]} ${maxAns[1]}")
}