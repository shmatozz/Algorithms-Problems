package yandexMobileDevSchool2024

fun main() {
    val steps = readln()
    val map = mutableMapOf<Pair<Int, Int>, Int>()

    var x = 0
    var y = 0
    map[Pair(x, y)] = 1

    for (step in steps) {
        when (step) {
            'D' -> y--
            'U' -> y++
            'L' -> x--
            'R' -> x++
        }

        map[Pair(x, y)] = map.getOrDefault(Pair(x, y), 0) + 1
    }

    println(map.values.count { it > 1 })
}