package tinkoffAlgorithms2024.w13_final_exam

import kotlin.math.min

data class Computer(
    val timePerTask: Long = 0,
    val maxTaskSeq: Long = 0 ,
    val sysBreak: Long = 0
)

fun checkTasksTesting(n: Int, computers: Array<Computer>, mid: Long) : Boolean {
    var tested = 0L

    for (i in computers.indices) {
        val testingCycleTime = computers[i].timePerTask * computers[i].maxTaskSeq + computers[i].sysBreak
        //                       Количество задач протестированное в осн. время   + Количество задач протестированное в оставшееся время
        val testedByComputer = (mid / testingCycleTime) * computers[i].maxTaskSeq + min(computers[i].maxTaskSeq, (mid % testingCycleTime) / computers[i].timePerTask)
        tested += testedByComputer

        if (tested >= n) {
            return true
        }
    }

    return tested >= n
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val computers = Array(m) { Computer() }

    repeat(m) { i ->
        val (t, ma, s) = readln().split(' ').map { it.toLong() }
        computers[i] = Computer(timePerTask = t, maxTaskSeq = ma, sysBreak = s)
    }

    var left = 0L
    var right = 1_000_000_000_000_000L
    while (left < right) {
        val mid = (left + right) / 2
        if (checkTasksTesting(n, computers, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    var remaining = n.toLong()
    val taskCounts = LongArray(computers.size) { 0 }
    for ((i, comp) in computers.withIndex()) {
        if (remaining <= 0) {
            break
        }

        val cycleTime = comp.timePerTask * comp.maxTaskSeq + comp.sysBreak
        val totalTestedByComputer = (left / cycleTime) * comp.maxTaskSeq + min(comp.maxTaskSeq, (left % cycleTime) / comp.timePerTask)

        taskCounts[i] = min(totalTestedByComputer, remaining)
        remaining -= taskCounts[i]
    }

    println(left)
    for (i in taskCounts) {
        print("$i ")
    }

}