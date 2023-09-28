package deepDiveExam

fun main() {
    val (n, k) = readln().split(' ').map{ it.toInt()}
    val users = mutableMapOf<String, Int>()
    val test = "zxcvbnd"
    repeat(n) {
        val user = readln()
        val message = readln()
        var gooseCount = 0

        if (message.startsWith("goose ")) gooseCount++
        if (message.endsWith(" goose")) gooseCount++
        if (message == "goose") gooseCount++

        for (i in 0 until message.length - 7) {
            if (message.subSequence(i, i + 7) == " goose ") {
                gooseCount++
            }
        }

        if (gooseCount > 0 || k == 0) {
            users[user] = users.getOrDefault(user, 0) + gooseCount
        }
    }

    val ans = mutableListOf<String>()
    for (i in users.keys.toTypedArray().sorted()) {
        if (users[i]!! >= k) ans.add(i)
    }

    println(ans.size)
    for (i in ans) {
        println(i)
    }
}