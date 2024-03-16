package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>
#include <algorithm>


int main() {
    int n, l, r;
    std::cin >> n;
    std::vector<std::pair<int, int>> cords(n * 2);

    for (int i = 0; i < n * 2;) {
        std::cin >> l >> r;
        cords[i++] = std::pair(l, 1);
        cords[i++] = std::pair(r, -1);
    }

    std::sort(cords.begin(), cords.end());

    int curCount = 0, ans = 0;
    for (int i = 0; i < n * 2 - 1; ++i) {
        curCount += cords[i].second;
        if (curCount > 0) {
            ans += cords[i + 1].first - cords[i].first;
        }
    }

    std::cout << ans << std::endl;
}
 */

fun main() {

}