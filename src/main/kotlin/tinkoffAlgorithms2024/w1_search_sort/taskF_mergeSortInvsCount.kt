package tinkoffAlgorithms2024.w1_search_sort

var invCounter = 0L

fun mergeSort(array: IntArray) : IntArray {
    if (array.size == 1) {
        return array
    }

    val mid = array.size / 2
    val left = mergeSort(array.sliceArray(IntRange(0, mid - 1)))
    val right = mergeSort(array.sliceArray(IntRange(mid, array.size - 1)))

    var i = 0
    var j = 0
    var curEl = 0

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            array[curEl] = left[i]
            i++
        } else {
            array[curEl] = right[j]
            j++
            invCounter += left.size - i
        }
        curEl++
    }

    while (i < left.size) {
        array[curEl] = left[i]
        i++
        curEl++
    }

    while (j < right.size) {
        array[curEl] = right[j]
        j++
        curEl++
    }

    return array
}

fun main() {
    val n = readln().toInt()
    var array = readln().split(' ').map { it.toInt() }.toIntArray()
    array = mergeSort(array)

    println(invCounter)
    for (el in array) print("$el ")
}