package easy

import kotlin.math.max
import kotlin.math.min

fun max(a: Long, b: Long, c: Long) : Long = max(a, max(b, c))

fun min(a: Long, b: Long, c: Long) : Long = min(a, min(b, c))

fun main() {
    val (a, b, c) = readln().split(' ').map { it.toLong() }
    println(a + b + c - max(a, b, c) - min(a, b, c))
}