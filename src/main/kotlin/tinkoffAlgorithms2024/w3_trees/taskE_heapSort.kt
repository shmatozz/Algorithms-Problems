package tinkoffAlgorithms2024.w3_trees

fun shift(array: IntArray, pos: Int, heapSize: Int) {
    var cur = pos
    while (cur * 2 + 1 < heapSize) {
        val leftChild = cur * 2 + 1
        var rightChild = cur * 2 + 2
        if (rightChild >= heapSize) {
            rightChild = leftChild
        }

        if (array[leftChild] >= array[rightChild] && array[cur] < array[leftChild]) {
            array[cur] += array[leftChild]
            array[leftChild] = array[cur] - array[leftChild]
            array[cur] -= array[leftChild]
            cur = leftChild
        } else if (array[leftChild] < array[rightChild] && array[cur] < array[rightChild]) {
            array[cur] += array[rightChild]
            array[rightChild] = array[cur] - array[rightChild]
            array[cur] -= array[rightChild]
            cur = rightChild
        } else {
            break
        }
    }
}

fun main() {
    val n = readln().toInt()
    val array = readln().split(' ').map { it.toInt() }.toIntArray()
    var heapSize = array.size

    for (i in (n / 2) - 1 downTo 0) {
        shift(array, i, heapSize)
    }

    for (i in 0 until n - 1) {
        array[0] += array[heapSize - 1]
        array[heapSize - 1] = array[0] - array[heapSize - 1]
        array[0] -= array[heapSize - 1]
        heapSize--
        shift(array, 0, heapSize)
    }

    for (i in array) print("$i ")
    println()
}