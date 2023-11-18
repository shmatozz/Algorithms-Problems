fun printMatrix(array: Array<Array<Int>>, n: Int, m: Int) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            print("${array[i][j]} ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}