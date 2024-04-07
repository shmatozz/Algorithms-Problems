package tinkoffAlgorithms2024.w7_dp

/*
#include <iostream>
#include <vector>
#include <string>

int main() {
    int n;
    std::cin >> n;
    std::vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }

    std::vector<int> dp(n + 1);
    std::vector<int> paths(n + 1);
    int totalMax = 0;
    for (int i = 0; i < n; ++i) {
        int max = 0;
        for (int j = 0; j < i; ++j) {
            if (arr[j] < arr[i] && dp[j + 1] > dp[max]) {
                max = j + 1;
            }
        }

        dp[i + 1] = dp[max] + 1;
        paths[i + 1] = max;

        if (dp[i + 1] > dp[totalMax]) {
            totalMax = i + 1;
        }
    }

    std::cout << dp[totalMax] << std::endl;

    int cur = totalMax;
    std::vector<int> ans;
    while (cur != 0) {
        ans.push_back(arr[cur - 1]);
        cur = paths[cur];
    }

    for (int i = ans.size() - 1; i >= 0; --i) {
        std::cout << ans[i] << ' ';
    }
    std::cout << std::endl;

    return 0;
}
 */

fun main() {
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }
    val dp = IntArray(n + 1) { 0 }
    val paths = IntArray(n + 1) { 0 }

    var totalMax = 0;
    for (i in 0 until n) {
        var max = 0;
        for (j in 0 until i) {
            if (arr[j] < arr[i] && dp[j + 1] > dp[max]) {
                max = j + 1
            }
        }

        dp[i + 1] = dp[max] + 1
        paths[i + 1] = max

        if (dp[i + 1] > dp[totalMax]) {
            totalMax = i + 1
        }
    }

    println(dp[totalMax])

    var cur = totalMax
    val ans = mutableListOf<Int>()
    while (cur != 0) {
        ans.add(arr[cur - 1])
        cur = paths[cur];
    }

    for (i in ans.size - 1 downTo 0) {
        print("${ans[i]} ")
    }
    println()
}