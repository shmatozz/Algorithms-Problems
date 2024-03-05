package someOtherTasks

fun main(args: Array<String>) {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val field = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        field[i] = readln().toString().toCharArray()
    }

    val countUp = Array(n) { IntArray(m) { 0 } }
    val countDown = Array(n) { IntArray(m) { 0 } }
    val countLeft = Array(n) { IntArray(m) { 0 } }
    val countRight = Array(n) { IntArray(m) { 0 } }
    val totalCount = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until m) {
        if (field[0][i] == 'W') countUp[0][i] = -1
        if (field[n - 1][i] == 'W') countDown[n - 1][i] = -1
    }

    for (i in 0 until n) {
        if (field[i][0] == 'W') countLeft[i][0] = -1
        if (field[i][m - 1] == 'W') countRight[i][m - 1] = -1
    }

    for (i in 1 until n) {
        for (j in 0 until m) {
            if (countUp[i - 1][j] == -1) {
                countUp[i][j] = 0
            } else if (field[i - 1][j] == 'B'){
                countUp[i][j] = countUp[i - 1][j] + 1
            } else {
                countUp[i][j] = countUp[i - 1][j]
            }
            if (field[i][j] == 'W') {
                countUp[i][j] = -1
            }
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in 0 until m) {
            if (countDown[i + 1][j] == -1) {
                countDown[i][j] = 0
            } else if (field[i + 1][j] == 'B'){
                countDown[i][j] = countDown[i + 1][j] + 1
            } else {
                countDown[i][j] = countDown[i + 1][j]
            }
            if (field[i][j] == 'W') {
                countDown[i][j] = -1
            }
        }
    }

    for (i in 0 until n) {
        for (j in 1 until m) {
            if (countLeft[i][j - 1] == -1) {
                countLeft[i][j] = 0
            } else if (field[i][j - 1] == 'B'){
                countLeft[i][j] = countLeft[i][j - 1] + 1
            } else {
                countLeft[i][j] = countLeft[i][j - 1]
            }
            if (field[i][j] == 'W') {
                countLeft[i][j] = -1
            }
        }
    }

    for (i in 0 until n) {
        for (j in m - 2 downTo 0) {
            if (countRight[i][j + 1] == -1) {
                countRight[i][j] = 0
            } else if (field[i][j + 1] == 'B'){
                countRight[i][j] = countRight[i][j + 1] + 1
            } else {
                countRight[i][j] = countRight[i][j + 1]
            }
            if (field[i][j] == 'W') {
                countRight[i][j] = -1
            }
        }
    }

    var maxI = 0
    var maxJ = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (field[i][j] == '.') {
                totalCount[i][j] = countUp[i][j] + countDown[i][j] + countLeft[i][j] + countRight[i][j]
                if (totalCount[i][j] > totalCount[maxI][maxJ]) {
                    maxI = i
                    maxJ = j
                }
            }
        }
    }

    println("${maxI + 1} ${maxJ + 1}")
}