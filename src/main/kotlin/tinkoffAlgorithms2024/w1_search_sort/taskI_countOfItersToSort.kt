package tinkoffAlgorithms2024.w1_search_sort

fun main() {
    val n = readln().toInt()
    val positions = readln().split(' ').map { it.toInt() }.toIntArray()
    val arrayToSort = IntArray(n) { 0 }
    val answers = mutableListOf<Int>()

    answers.add(1)
    var zerosEnd = 1
    val onesEndBounds = intArrayOf(-1, -1)
    var onesStart: Int
    var totalOnes = 0
    for (i in positions) {
        arrayToSort[i - 1] = 1
        //for (j in arrayToSort) print("$j ")
        //println()

        totalOnes++
        zerosEnd = if (n - i > 0 && zerosEnd != 0) 1
                       else 0
        if (onesEndBounds.first() == -1 || onesEndBounds[1] < i - 1) {
            onesEndBounds[0] = i
            onesEndBounds[1] = i
        } else if (i == onesEndBounds[0] - 1) {
            var j = i - 1
            while (j >= 0 && arrayToSort[j] == 1) {
                onesEndBounds[0] = j + 1
                j--
            }
        } else if (i == onesEndBounds[1] + 1) {
            onesEndBounds[1] = i
        }

        onesStart = totalOnes - (onesEndBounds[1] - onesEndBounds[0] + 1)

        //println("onesStart = $onesStart; onesEndBounds = ${onesEndBounds[0]} ${onesEndBounds[1]}; zerosEnd = $zerosEnd")
        //println("$onesStart + ${(onesEndBounds[1] - onesEndBounds[0] + 1)} * $zerosEnd + 1 = ${onesStart + (onesEndBounds[1] - onesEndBounds[0] + 1) * zerosEnd + 1}")
        //println()
        answers.add(onesStart + (onesEndBounds[1] - onesEndBounds[0] + 1) * zerosEnd + 1)
    }

    for (i in answers) print("$i ")
}