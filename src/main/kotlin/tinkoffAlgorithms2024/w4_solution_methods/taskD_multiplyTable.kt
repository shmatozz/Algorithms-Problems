package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <stack>
#include <vector>

int main() {
    long long n, k;
    std::cin >> n >> k;

    long long left = 1, right = n * n;
    while (left < right) {
        long long mid = (left + right) / 2;

        long long count = 0;
        for (int i = 1; i <= n; ++i) {
            if (mid / i < n) {
                count += mid / i;
            } else {
                count += n;
            }
        }

        if (count < k) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    std::cout << left << std::endl;

    return 0;
}
 */

fun main() {

}