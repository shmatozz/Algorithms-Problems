package tinkoffAlgorithms2024.w2_data_structures

/*
#include <iostream>
#include <stack>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    std::vector<int> array(n);
    std::vector<long long> prefSum(n + 1, 0);
    std::vector<int> prev(n, -1);
    std::vector<int> next(n, -1);
    std::stack<int> stack;

    for (int i = 0; i < n; i++) {
        std::cin >> array[i];
        prefSum[i + 1] = prefSum[i] + array[i];
    }

    for (int i = 0; i < n; ++i) {
        while (!stack.empty() && array[stack.top()] >= array[i]) {
            stack.pop();
        }
        if (!stack.empty()) {
            prev[i] = stack.top();
        }
        stack.push(i);
    }

    while (!stack.empty()) stack.pop();

    for (int i = n - 1; i >= 0; --i) {
        while (!stack.empty() && array[stack.top()] >= array[i]) {
            stack.pop();
        }
        if (!stack.empty()) {
            next[i] = stack.top();
        }
        stack.push(i);
    }

    long long max = 0;
    for (int i = 0; i < n; ++i) {
        int left = prev[i] != -1 ? prev[i] + 1 : 0;
        int right = next[i] != -1 ? next[i] : n;

        if (array[i] * (prefSum[right] - prefSum[left]) > max) {
            max = array[i] * (prefSum[right] - prefSum[left]);
        }
    }

    std::cout << max << std::endl;

    return 0;
}
 */

fun main() {
    println("CPP Solution above")
}