package leetcode.easy

fun findContentChildren(g: IntArray, s: IntArray): Int {
    var childPointer = 0
    var cookiePointer = 0
    var childrenWithCookies = 0
    g.sort()
    s.sort()

    while (childPointer < g.size && cookiePointer < s.size) {
        if (g[childPointer] <= s[cookiePointer]) {
            childrenWithCookies++
            childPointer++
            cookiePointer++
        } else if (g[childPointer] > s[cookiePointer]) {
            cookiePointer++
        }
    }

    return childrenWithCookies
}

fun main() {
    println(findContentChildren(intArrayOf(1, 2 ,3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}
