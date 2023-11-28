package medium

fun main() {
    val n = readln().toInt()
    val potentials = readln().split(' ').map { it.toLong() }.toLongArray()

    var currentProductNoZeros = 1L
    var countZeros = 0
    for (i in potentials) {
        if (i == 0L) {
            countZeros++
        } else {
            currentProductNoZeros *= i
        }
    }

    val sumWithGift = LongArray(n)
    var giftInd = 0
    for (i in potentials.indices) {
        if (potentials[i] == 0L && countZeros == 1) {
            sumWithGift[i] = currentProductNoZeros
        } else if (potentials[i] == 0L && countZeros > 1) {
            sumWithGift[i] = 0
        } else if (countZeros > 0) {
            sumWithGift[i] = 0
        } else {
            sumWithGift[i] = currentProductNoZeros / potentials[i]
        }

        if (sumWithGift[i] > sumWithGift[giftInd]) {
            giftInd = i
        }
    }

    // for (i in sumWithGift) print("$i ")
    // println()
    println(potentials[giftInd])
}