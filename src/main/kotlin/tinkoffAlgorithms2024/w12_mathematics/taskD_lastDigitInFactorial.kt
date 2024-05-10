package tinkoffAlgorithms2024.w12_mathematics

fun main() {
    val n = readln().toInt()

    var lastDigit = 1
    var count5 = 0
    var count2 = 0
    for (i in 2 .. n) {
        var cur = i
        while (cur % 5 == 0) {
            cur /= 5
            count5++
        }
        while (cur % 2 == 0) {
            cur /= 2
            count2++
        }

        lastDigit = (lastDigit * cur) % 10
    }

    for (i in 0 until count2 - count5) {
        lastDigit = (lastDigit * 2) % 10
    }

    println(lastDigit)
}