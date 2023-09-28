package internWeekOfferExam

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val field = Array(n) { String() }

    for (i in 0 until n) {
        field[i] = readln()
    }

    var isFigure = false
    val countMatrix = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if ((field[i][j] == '/' || field[i][j] == '\\') && !isFigure) {
                isFigure = true
                countMatrix[i][j] = 1
            } else if ((field[i][j] == '/' || field[i][j] == '\\') && isFigure) {
                countMatrix[i][j] = 1
                isFigure = false
            } else if (isFigure) {
                countMatrix[i][j] = 2
            }
        }
    }

    var answer = 0

    for (i in 0 until n) {
        answer += countMatrix[i].sum()
    }

    println(answer / 2)
}