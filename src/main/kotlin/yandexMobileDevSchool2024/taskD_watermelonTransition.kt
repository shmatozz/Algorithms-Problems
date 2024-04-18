package yandexMobileDevSchool2024

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val watermelons = readln().split(' ').map { it.toInt() }.toIntArray()

    watermelons.sort()
    var left = 0
    var right = n - 1
    var impossible = false
    var count = 0

    while (left <= right) {
        if (watermelons[left] > k || watermelons[right] > k) {
            impossible = true
            break
        }

        if (watermelons[left] + watermelons[right] <= k) {
            left++
            right--
        } else if (left == right) {
            left++
        } else {
            right--
        }
        count++
    }

    if (impossible) {
        println("Impossible")
    } else {
        println(count)
    }
}