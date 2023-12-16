package tinkoffStartWinter2024

fun main() {
    val n = readln().toInt()

    for (i in 0 until n) {
        val letters = readln()

        if (letters.length != 7) {
            println("No")
        } else {
            if (letters.toCharArray().sorted() == "TINKOFF".toCharArray().sorted()) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}