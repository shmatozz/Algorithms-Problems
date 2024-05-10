package tinkoffAlgorithms2024.w12_mathematics

import kotlin.math.sqrt

fun main() {
    var n = readln().toInt()

    val delims = mutableListOf<Int>()

    for (del in 2 until sqrt(n.toFloat()).toInt() + 1) {
        while (n % del == 0) {
            delims.add(del)
            n /= del
        }
    }

    if (n > 1) {
        delims.add(n)
    }

    var current = delims[0]
    var count = 0
    for (i in delims) {
        if (i == current) {
            count++
        } else {
            if (count > 1) {
                print("$current^$count*")
            } else {
                print("$current*")
            }
            current = i
            count = 1
        }
    }
    if (count > 1) {
        println("$current^$count")
    } else {
        println("$current")
    }
}