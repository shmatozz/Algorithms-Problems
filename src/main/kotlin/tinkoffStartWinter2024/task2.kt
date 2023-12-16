package tinkoffStartWinter2024

fun main() {
    val t = readln().toInt()

    for (i in 0 until t) {
        val n = readln().toInt()
        val potentials = readln().split(" ").map { it.toInt() }.toIntArray()

        if (potentials.count { it % 2 == 1 } % 2 == 0) {
            println("Yes")
        } else {
            println("No")
        }
    }
}