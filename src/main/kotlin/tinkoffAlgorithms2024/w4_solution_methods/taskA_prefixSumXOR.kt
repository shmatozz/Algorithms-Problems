package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    std::vector<long long> array(n), prefixSum(n + 1, 0), prefixXOR(n + 1, 0);
    for (int i = 0; i < n; ++i) {
        std::cin >> array[i];
        prefixSum[i + 1] = prefixSum[i] + array[i];
        prefixXOR[i + 1] = prefixXOR[i] ^ array[i];
    }

    int m;
    std::cin >> m;

    for (int i = 0; i < m; ++i) {
        int req, l, r;
        std::cin >> req >> l >> r;

        if (req == 1) {
            std::cout << prefixSum[r] - prefixSum[l - 1] << std::endl;
        } else if (req == 2) {
            std::cout << (prefixXOR[r] ^ prefixXOR[l - 1]) << std::endl;
        }
    }
}
 */

fun main() {
    val n = readln().toInt()
    val array = readln().split(' ').map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    val prefixSum = IntArray(n + 1) { 0 }
    val prefixXOR = IntArray(n + 1) { 0 }

    for (i in 0 until n) {
        prefixSum[i + 1] = prefixSum[i] + array[i]
        prefixXOR[i + 1] = prefixXOR[i] xor array[i]
    }

    repeat(m) {
        val (req, l, r) = readln().split(' ').map { it.toInt() }

        if (req == 1) {
            println(prefixSum[r] - prefixSum[l - 1])
        } else if (req == 2) {
            println(prefixXOR[r] xor prefixXOR[l - 1])
        }
    }
}