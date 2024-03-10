package tinkoffAlgorithms2024.w4_solution_methods

/*
#include <iostream>
#include <vector>

int main() {
    int n, m, k;
    std::cin >> n >> m >> k;
    std::vector<std::vector<int>> matrix(n, std::vector<int>(m));
    std::vector<std::vector<long long>> prefSums(n + 1, std::vector<long long>(m + 1));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            std::cin >> matrix[i][j];
        }
    }

    for (int i = 0; i < m; ++i) {
        prefSums[1][i + 1] = prefSums[1][i] + matrix[0][i];
    }

    for (int i = 0; i < n; ++i) {
        prefSums[i + 1][1] = prefSums[i][1] + matrix[i][0];
    }

    for (int i = 1; i < n; ++i) {
        for (int j = 1; j < m; ++j) {
            prefSums[i + 1][j + 1] = prefSums[i + 1][j] + prefSums[i][j + 1] + matrix[i][j] - prefSums[i][j];
        }
    }

    for (int i = 0; i < k; ++i) {
        int y1, x1, y2, x2;
        std::cin >> y1 >> x1 >> y2 >> x2;

        std::cout << prefSums[y2][x2] - prefSums[y2][x1 - 1] - prefSums[y1 - 1][x2] + prefSums[y1 - 1][x1 - 1] << std::endl;
    }
}
 */

fun main() {

}