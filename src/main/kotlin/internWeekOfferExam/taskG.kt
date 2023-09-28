package internWeekOfferExam

fun main() {
    val n = readln().toInt()
    val s = readln()
    val times = readln().split(" ").map { it.toInt() }.toIntArray()

    val timesForEach = Array(n) { 0 }
    timesForEach[0] = times[0]
    var max = timesForEach[0]
    var indMax = 0

    for (i in 1 until n) {
        timesForEach[i] = times[i] - times[i - 1]
        if (timesForEach[i] >= max) {
            max = timesForEach[i]
            indMax = i
        }
    }

    println(s[indMax])
}