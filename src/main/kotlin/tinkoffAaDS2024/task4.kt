package tinkoffAaDS2024

fun main() {
    val n = readln().toInt()
    val numbersSet = readln().split(" ").map { it.toInt() }.toSet()
    val numbers = numbersSet.toIntArray()

    numbers.sort()

    var first = 0
    var second = 1

    while (second < numbers.size) {
        if (numbers[second] - numbers[first] > 1 && first + 1 == second) {
            print("${numbers[first]} ")
            first = second
            second++
        } else if (numbers[second] - numbers[first] == 1 && first + 1 == second) {
            print("${numbers[first]} ")
            while (second < numbers.size && numbers[second] - numbers[second - 1] == 1) second++
            second--
            if (first + 1 == second) {
                print("${numbers[second]} ")
            } else {
                print("... ${numbers[second]} ")
            }
            first = second + 1
            second += 2
        }
    }
    if (first < numbers.size) {
        print("${numbers[first]}")
    }
}