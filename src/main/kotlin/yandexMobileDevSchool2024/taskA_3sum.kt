package yandexMobileDevSchool2024

fun main() {
    val (a, b, c) = readln().split(' ').map { it.toInt() }

    if (a + b == c || a + c == b || b + c == a) {
        println("YES")
    } else {
        println("NO")
    }
}