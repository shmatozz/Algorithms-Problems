package tinkoffAlgorithms2024.w3_trees

fun main() {
    val n = readln().toInt()
    val heap = mutableListOf<Int>()

    repeat(n) {
        val command = readln().split(' ')
        if (command[0] == "0") {
            heap.add(command[1].toInt())

            var cur = heap.size - 1
            while (heap[cur] > heap[(cur - 1) / 2]) {
                heap[cur] += heap[(cur - 1) / 2]
                heap[(cur - 1) / 2] = heap[cur] - heap[(cur - 1) / 2]
                heap[cur] -= heap[(cur - 1) / 2]

                cur = (cur - 1) / 2
            }
        } else {
            println(heap[0])

            heap[0] += heap[heap.size - 1]
            heap[heap.size - 1] = heap[0] - heap[heap.size - 1]
            heap[0] -= heap[heap.size - 1]
            heap.removeLast()

            var cur = 0
            while (cur * 2 + 1 < heap.size) {
                val leftChild = cur * 2 + 1
                var rightChild = cur * 2 + 2
                if (rightChild >= heap.size) {
                    rightChild = leftChild
                }

                if (heap[leftChild] >= heap[rightChild] && heap[cur] < heap[leftChild]) {
                    heap[cur] += heap[leftChild]
                    heap[leftChild] = heap[cur] - heap[leftChild]
                    heap[cur] -= heap[leftChild]
                    cur = leftChild
                } else if (heap[leftChild] < heap[rightChild] && heap[cur] < heap[rightChild]) {
                    heap[cur] += heap[rightChild]
                    heap[rightChild] = heap[cur] - heap[rightChild]
                    heap[cur] -= heap[rightChild]
                    cur = rightChild
                } else {
                    break
                }
            }
        }
    }
}