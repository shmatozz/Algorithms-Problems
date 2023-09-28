package deepDiveExam

fun main() {
    val n = readln().toInt()
    val percentagesHour = readln().split(' ').map { it.toInt() }.toIntArray()

    println(100 / percentagesHour.sum())
}
