package tinkoffAlgorithms2024.w2_data_structures

/*
#include <iostream>
#include <vector>
#include <deque>

int main() {
    int n, k;
    std::cin >> n >> k;
    std::vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }

    std::deque<int> deque;
    for (int i = 0; i < k; ++i) {
        while (!deque.empty() && arr[deque.back()] >= arr[i]) {
            deque.pop_back();
        }
        deque.push_back(i);
    }
    std::cout << arr[deque.front()] << ' ';

    for (int i = k; i < n; ++i) {
        if (i - k + 1 > deque.front()) {
            deque.pop_front();
        }

        while (!deque.empty() && arr[deque.back()] >= arr[i]) {
            deque.pop_back();
        }
        deque.push_back(i);

        std::cout << arr[deque.front()] << ' ';
    }
    std::cout << std::endl;

    return 0;
}
 */

fun main() {
    println("CPP solution above")
}