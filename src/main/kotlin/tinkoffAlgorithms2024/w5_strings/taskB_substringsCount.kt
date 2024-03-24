package tinkoffAlgorithms2024.w5_strings

fun main() {
    val str = readLine()!!
    val q = readLine()!!.toInt()

    repeat(q) {
        val substr = readLine()!!
        val indexes = mutableListOf<Int>()
        val substrLength = substr.length

        var substrHashInStr = 0L
        var substrHash = 0L
        var primePower = 1L

        for (i in 0 until substrLength) {
            substrHashInStr = substrHashInStr * 31 + str[i].code
            substrHash = substrHash * 31 + substr[i].code
            primePower *= 31
        }

        var count = 0
        for (i in 0 until str.length - substrLength + 1) {
            if (substrHash == substrHashInStr && str.substring(i, i + substrLength) == substr) {
                count++
                indexes.add(i)
            }

            if (i < str.length - substrLength) {
                substrHashInStr = substrHashInStr * 31 - str[i].code * primePower + str[i + substrLength].code
            }
        }

        print("$count ")
        for (i in indexes) print("$i ")
        println()
    }
}
