package tinkoffAaDS2024

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableMap<Int, Int>>()
    repeat(m) {
        val (u, d, v) = readln().split(" ").map { it.toInt() }
        if (u !in map.keys) {
            map[u] = mutableMapOf()
        }
        map[u]?.set(d, v)
    }

    val way = readln().split(" ").map { it.toInt() }.toIntArray()

    var curPoint = 1
    for (car in way) {
        if (curPoint !in map.keys || map[curPoint]!!.getOrDefault(car, 0) == 0) {
            curPoint = 0
            break
        } else {
            curPoint = map[curPoint]?.get(car)!!
        }
    }

    println(curPoint)
}