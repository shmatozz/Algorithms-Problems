package april1stTinkoffContest

/*
str = input()
print("Tinkof" + 'f' * str.count('f'))
 */

fun main() {
    val str = readln()
    println("Tinkof" + str.count { it == 'f' })
}