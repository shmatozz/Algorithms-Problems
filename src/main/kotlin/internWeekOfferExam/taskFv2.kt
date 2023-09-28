package internWeekOfferExam

import kotlin.math.min

fun main() {
    val s = readln()
    val left = Array(s.length + 1) { 0 }
    val right = Array(s.length + 1) { 0 }


    for (i in s.indices) {
        if (s[i] == '1' || s[i] == '3') {
            left[i + 1] = left[i] + 1
        } else {
            left[i + 1] = left[i]
        }
    }

    for (i in left) print("$i ")
    println()
    for (i in right) print("$i ")
    println()

    right[0] = 1
    for (i in s.indices) {
        if (s[i] == '2' || s[i] == '3') {
            right[i + 1] = min(right[i] + 1, left[i + 1] + 1)
        } else {
            right[i + 1] = right[i]
        }
        if (right[i + 1] + 1 < left[i + 1]) {
            left[i + 1] = right[i + 1] + 1
            for (j in i + 1 until s.length) {
                if (s[j] == '1' || s[j] == '3') {
                    left[j + 1] = left[j] + 1
                } else {
                    left[j + 1] = left[j]
                }
            }
        }
    }

    println(right[s.length])

    for (i in left) print("$i ")
    println()
    for (i in right) print("$i ")
    println()
}