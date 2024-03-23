package tinkoffAlgorithms2024.w5_strings

/*
s = input()
m = int(input())
prefix_hash = [0] * (len(s) + 1)
p = 1
for i in range(len(s)):
    prefix_hash[i + 1] = (prefix_hash[i] + (ord(s[i]) - ord('a') + 1) * p) % 1000000009
    p = (p * 13) % 1000000009

for _ in range(m):
    a, b, c, d = map(int, input().split())

    hash_ab = (((prefix_hash[b] - prefix_hash[a - 1] + 1000000009) % 1000000009) * pow(13, len(s) - a, 1000000009)) % 1000000009
    hash_cd = (((prefix_hash[d] - prefix_hash[c - 1] + 1000000009) % 1000000009) * pow(13, len(s) - c, 1000000009)) % 1000000009

    if hash_ab == hash_cd:
        print("Yes")
    else:
        print("No")

 */

fun main() {
    val str = readln()
    val m = readln().toInt()

    repeat(m) {
        val (a, b, c, d) = readln().split(' ').map { it.toInt() }

        println(str.subSequence(a, b))
        if (str.subSequence(a, b) == str.subSequence(c, d)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}