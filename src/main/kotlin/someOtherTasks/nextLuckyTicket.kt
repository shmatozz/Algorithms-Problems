package someOtherTasks

fun main(args: Array<String>) {
    var n = readln().toInt()
    var left = (n / 100000) + (n % 100000 / 10000) + (n % 10000 / 1000)
    var right = n % 10 + n % 100 / 10 + n % 1000 / 100

    while (right != left) {
        n++
        right = n % 10 + n % 100 / 10 + n % 1000 / 100
        left = (n / 100000) + (n % 100000 / 10000) + (n % 10000 / 1000)
    }
    println(n)
}