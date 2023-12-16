package tinkoffStartWinter2024

data class Child(var count: Int, val friends: MutableList<Child>)

fun main() {
    val (n, m, q) = readln().split(" ").map { it.toInt() }
    val alreadyCounted = readln().split(" ").map { it.toInt() }.toIntArray()
    val children = List(n) { Child(0, mutableListOf()) }

    for (i in 0 until n) {
        children[i].count = alreadyCounted[i]
    }

    repeat(m) {
        val (first, second) = readln().split(" ").map { it.toInt() }
        children[first - 1].friends.add(children[second - 1])
        children[second - 1].friends.add(children[first - 1])
    }

    repeat(q) {
        val query = readln().split(" ")

        when (query[0]) {
            "?" -> println(children[query[1].toInt() - 1].count)
            "+" -> {
                val toAddChildren = children[query[1].toInt() - 1].friends
                for (friend in toAddChildren) {
                    friend.count += query[2].toInt()
                }
            }
        }
    }
}