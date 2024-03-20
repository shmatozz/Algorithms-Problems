package tinkoffAlgorithms2024.w5_strings

fun main() {
    val str = readln()
    val m = readln().toInt()

    repeat(m) {
        val (a, b, c, d) = readln().split(' ').map { it.toInt() }

        println(str.subSequence(a, b))
        if (str.subSequence(a, b) == str.subSequence(c, d)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}