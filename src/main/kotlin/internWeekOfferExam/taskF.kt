package internWeekOfferExam

fun main() {
    val s = readln()
    val left = Array(s.length + 1) { 0 }
    val right = Array(s.length + 1) { 0 }

    for (i in s.length - 1 downTo 0) {
        if (s[i] == '1') {
            left[i] = left[i + 1] + 1
            right[i] = 0
        } else if (s[i] == '2') {
            right[i] = right[i + 1] + 1
            left[i] = 0
        } else if (s[i] == '3') {
            left[i] = left[i + 1] + 1
            right[i] = right[i + 1] + 1
        }
    }

    // var first = 0; var second = 0 // pointers, first = left side of main road, second = right side
    var crosses = 0
    var status = 0 // status == 0 - on left side now, status == 1 - on right side

    for (i in 0 until s.length) {
        if (left[i] > right[i] && status == 0) {
            status = 1
            crosses++
        } else if (right[i] > left[i] && status == 1) {
            status = 0
            crosses++
        }

        crosses += if ((left[i] > 0 && status == 0) || (right[i] > 0 && status == 1)) 1 else 0
    }

    if (status == 0) crosses++

    println(crosses)

    for (i in s.indices) print("${left[i]} ")
    println()
    for (i in s.indices) print("${right[i]} ")
    println()
}