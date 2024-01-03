package leetcode.medium

fun numberOfBeams(bank: Array<String>): Int {
    var totalBeams = 0
    var firstRow = 0
    var secondRow = 0

    for (row in bank) {
        val curRow = row.count{ it == '1' }

        if (curRow != 0) {
            if (firstRow == 0) {
                firstRow = curRow
            }
            else if (secondRow == 0) {
                secondRow = curRow
                totalBeams += firstRow * secondRow
            } else {
                firstRow = secondRow
                secondRow = curRow
                totalBeams += firstRow * secondRow
            }
        }
    }

    return totalBeams
}

fun main() {
    println(numberOfBeams(arrayOf("011001", "000000", "010100", "001000")))
    println(numberOfBeams(arrayOf("000", "111", "000")))
}