package tinkoffAlgorithms2024.w11_solution_methods2

fun getPath(v: Int, tree: IntArray) : MutableList<Int> {
    val path = mutableListOf<Int>()
    path.add(v)

    if (v == 0) return path

    var cur = tree[v - 1]
    while (cur != 0) {
        path.add(cur)
        cur = tree[cur - 1]
    }
    path.add(cur)

    return path
}

fun main() {
    val n = readln().toInt()
    val tree = readln().split(' ').map { it.toInt() }.toIntArray()
    val m = readln().toInt()

    repeat(m) {
        val (u, v) = readln().split(' ').map { it.toInt() }

        val uPath = getPath(u, tree)
        val vPath = getPath(v, tree)

        var uPointer = uPath.size - 1
        var vPointer = vPath.size - 1

        while (uPointer >= 0 && vPointer >= 0) {
            if (uPath[uPointer] != vPath[vPointer]) {
                break
            }
            uPointer--
            vPointer--
        }
        println(uPath[uPointer + 1])
    }
}