package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>
#include <algorithm>

bool checkDistance(std::vector<int>& vec, int dist, int n_cows) {
    int cows = 1;
    int cur_cow = vec[0];
    for (auto i : vec) {
        if (i - cur_cow >= dist) {
            cows++;
            cur_cow = i;
        }
    }
    return cows >= n_cows;
}

int main() {
    int n, k;
    std::cin >> n >> k;
    std::vector<int> vec(n);
    for (int i = 0; i < n; ++i) { std::cin >> vec[i]; }
    int low = 0, high = vec[n - 1] - vec[0] + 1, mid;
    while (low + 1 < high) {
        mid = (low + high) / 2;
        if (checkDistance(vec, mid, k)) {
            low = mid;
        } else {
            high = mid;
        }
    }
    std::cout << low << std::endl;
}
 */

fun main() {

}