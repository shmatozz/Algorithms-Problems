package easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

// dynamic programming
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val nums: Array<Int> = reader.readLine().split(" ").map { it.toInt() }.toTypedArray()

    nums.sort()

    if (n == 2) {
        println(nums[1] - nums[0])
    } else {
        val dp = Array(n) { 0 }
        dp[0] = 10001
        dp[1] = nums[1] - nums[0]

        for (i in 2 until n) {
            dp[i] = min(dp[i - 1], dp[i - 2]) + nums[i] - nums[i - 1]
        }

        println(dp[n - 1])
    }

    reader.close()
    writer.close()
}