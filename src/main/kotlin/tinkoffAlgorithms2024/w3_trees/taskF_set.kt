package tinkoffAlgorithms2024.w3_trees

class Node(val value: Int, var left: Node? = null, var right: Node? = null)

class Set {
    private var root: Node? = null

    fun add(i: Int) {
        if (root == null) {
            root = Node(i)
            return
        }

        var cur = root
        while (cur != null) {
            if (cur.value == i) {
                return
            } else if (cur.value < i) {
                if (cur.right == null) {
                    cur.right = Node(i)
                    return
                } else {
                    cur = cur.right
                }
            } else  {
                if (cur.left == null) {
                    cur.left = Node(i)
                    return
                } else {
                    cur = cur.left
                }
            }
        }
    }

    fun next(i: Int) : Int {
        var min = -1

        var cur = root

        while (cur != null) {
            if (cur.value == i) {
                return i
            } else if (cur.value > i) {
                min = cur.value
                cur = cur.left
            } else {
                cur = cur.right
            }
        }

        return min
    }
}

fun main() {
    val n = readln().toInt()
    val set = Set()
    var lastTask = ""
    var y = 0

    repeat(n) {
        val task = readln().split(' ')
        if (task[0] == "+") {
            if (lastTask == "" || lastTask == "+") {
                set.add(task[1].toInt())
            } else {
                set.add((task[1].toInt() + y) % 1000000000)
            }
        } else if (task[0] == "?") {
            y = set.next(task[1].toInt())
            println(y)
        }
        lastTask = task[0]
    }
}