package tinkoffAlgorithms2024.w1_search_sort

fun f(a: Int, b: Int, c: Int, d: Int, x: Double) : Double {
    return (a * x * x * x) + (b * x * x) + (c * x) + d
}

fun main() {
    val (a, b, c, d) = readln().split(' ').map { it.toInt() }
    val epsilon = 1e-10
    var right = 1.0
    while (f(a, b, c, d, right) * f(a, b, c, d, -right) >= 0) right *= 2
    var left = -right

    var x = 0.0
    while (right - left > epsilon) {
        x = (left + right) / 2

        if (f(a, b, c, d, x) * f(a, b, c, d, right) > 0) {
            right = x
        } else {
            left = x
        }
    }

    println(x)
}