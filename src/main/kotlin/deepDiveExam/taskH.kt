package deepDiveExam

fun main() {
    val s = readln()
    val left = Array(s.length + 1) { 0 }
    val right = Array(s.length + 1) { 0 }
    right[0] = 1

    var curLeft = left[0]
    var curRight = right[0]
    for (i in 1..s.length) {
        if (s[i - 1] == '1') {
            right[i] = curRight
            curLeft++
            left[i] = curLeft
        } else if (s[i - 1] == '2') {
            left[i] = curLeft
            curRight++
            right[i] = curRight
        } else {
            curLeft++
            curRight++
            right[i] = curRight
            left[i] = curLeft
        }

        if (right[i] + 1 < left[i]) {
            left[i] = right[i] + 1
            curLeft = right[i] + 1
        } else if (left[i] + 1 < right[i]) {
            right[i] = left[i] + 1
            curRight = left[i] + 1
        }
    }

    println(right[s.length])

    for (i in left) print("$i ")
    println()
    for (i in right) print("$i ")
    println()
}