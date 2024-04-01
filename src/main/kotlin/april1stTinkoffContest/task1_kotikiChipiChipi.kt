package april1stTinkoffContest

// 0 - 2926, 4375 - 5303 * 2, 6744 - 8300 / 2
fun main() {
    val n = readln().toInt()

    if (n <= 2926) {
        println(n)
    } else if (n in 2926..4375) {
        println(2926)
    } else if (n in 4376 .. 5303) {
        println(2926 + (n - 4376) * 2)
    } else if (n in 5303 .. 6744) {
        println(2926 + 1856)
    } else if (n in 6744 .. 8300) {
        println(2926 + 1856 + (n - 6744) / 2)
    } else {
        println(2926 + 1856 + 778)
    }
}