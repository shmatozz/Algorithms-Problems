package someOtherTasks

fun main(args: Array<String>) {
    val (m, n) = readln().split(' ').map { it.toInt() }
    val callsQueue = mutableListOf<String>()

    repeat(n) {
        val call = readln()
        if (callsQueue.contains(call)) {
            callsQueue.remove(call)
            callsQueue.add(call)
        } else if (callsQueue.size == m) {
            callsQueue.removeFirst()
            callsQueue.add(call)
        } else {
            callsQueue.add(call)
        }
    }

    val count = callsQueue.size
    while (callsQueue.isNotEmpty()) {
        println(callsQueue.last)
        callsQueue.removeLast()
    }

    for (i in 0 until m - count) {
        println("<Empty>")
    }
}