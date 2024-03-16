package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>
#include <algorithm>


int main() {
    int n;
    std::cin >> n;
    std::vector<std::pair<int, int>> cords;
    int lh, lm, ls, rh, rm, rs;
    int curCount = 0;

    for (int i = 0; i < n; ++i) {
        std::cin >> lh >> lm >> ls >> rh >> rm >> rs;
        int totalLS = lh * 3600 + lm * 60 + ls;
        int totalRS = rh * 3600 + rm * 60 + rs;

        if (totalLS == totalRS) {
            cords.emplace_back(0, 1);
            cords.emplace_back(86400, -1);
        } else if (totalLS > totalRS) {
            cords.emplace_back(0, 1);
            cords.emplace_back(totalRS, -1);
            cords.emplace_back(totalLS, 1);
            cords.emplace_back(86400, -1);
        } else {
            cords.emplace_back(totalLS, 1);
            cords.emplace_back(totalRS, -1);
        }
    }

    std::sort(cords.begin(), cords.end());

    int ans = 0;
    for (int i = 0; i < cords.size() - 1; ++i) {
        curCount += cords[i].second;
        if (curCount == n) {
            ans += cords[i + 1].first - cords[i].first;
        }
    }

    std::cout << ans << std::endl;
}
 */

fun main() {

}