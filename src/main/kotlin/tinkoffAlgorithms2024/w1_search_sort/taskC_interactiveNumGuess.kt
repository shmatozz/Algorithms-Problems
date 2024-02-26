
fun main() {
    val n = readln().toInt()
    var left = 0;
    var right = n;

    while (left < right) {
        val mid = (left + right) / 2 + (left + right) % 2
        println(mid)
        System.out.flush()

        val answer = readln()
        if (answer == "<") {
            right = mid - 1
        } else if (answer == ">=") {
            left = mid
        }
    }

    println("! $left")
    System.out.flush()
}