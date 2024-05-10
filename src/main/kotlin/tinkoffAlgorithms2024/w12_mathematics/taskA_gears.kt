package tinkoffAlgorithms2024.w12_mathematics

fun gcd(a: Long, b: Long) : Long {
    if (a == 0L || b == 0L) {
        return if (a > b) a else b
    }

    return gcd(b, a % b)
}

fun main() {
    val (n, k) = readln().split(' ').map { it.toLong() }

    println((n * k) / gcd(n, k))
}