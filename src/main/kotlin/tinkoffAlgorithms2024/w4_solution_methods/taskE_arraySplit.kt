package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int n, k;
    std::cin >> n >> k;
    std::vector<long long> arr(n);
    long long left = 0, right = 0, mid;
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
        right += arr[i];
    }

    while (left + 1 < right) {
        mid = (left + right) / 2;

        long long countParts = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > mid) {
                countParts = -1;
                break;
            }
            if (sum + arr[i] > mid) {
                countParts++;
                sum = 0;
            }
            sum += arr[i];
        }
        countParts += sum > 0 && countParts != -1 ? 1 : 0;


        if (countParts != -1 && countParts <= k) {
            right = mid;
        } else {
            left = mid;
        }
    }

    std::cout << right << std::endl;
}
 */

fun main() {

}