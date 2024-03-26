package tinkoffAlgorithms2024.w6_graphs

/*
#include <iostream>
#include <vector>
#include <stack>
#include <set>
#include <algorithm>
#include <queue>

bool inBoard(int n, int x, int y) {
    return (x > 0 && x <= n) && (y > 0 && y <= n);
}

int main() {
    int n, x1, y1, x2, y2;
    std::cin >> n;
    std::cin >> x1 >> y1;
    std::cin >> x2 >> y2;

    std::vector<std::vector<int>> lens(n + 1, std::vector<int>(n + 1, -1));
    std::vector<std::vector<std::pair<int, int>>> paths(n + 1, std::vector<std::pair<int, int>>(n + 1, std::pair<int, int>(-1, -1)));
    lens[x1][y1] = 0;
    std::vector<std::pair<int, int>> steps = {{2, 1}, {2, -1},
                                              {1, 2}, {1, -2},
                                              {-2, 1}, {-2, -1},
                                              {-1, 2}, {-1, -2}};
    std::queue<std::pair<int, int>> queue;

    queue.emplace(x1, y1);
    while (!queue.empty()) {
        std::pair<int, int> cur = queue.front();
        queue.pop();
        for (auto step : steps) {
            if (inBoard(n, cur.first + step.first, cur.second + step.second) &&
                    lens[cur.first + step.first][cur.second + step.second] == -1)   {
                lens[cur.first + step.first][cur.second + step.second] = lens[cur.first][cur.second] + 1;
                paths[cur.first + step.first][cur.second + step.second] = std::make_pair(cur.first, cur.second);
                queue.emplace(cur.first + step.first, cur.second + step.second);
            }
        }
    }

    std::vector<std::pair<int, int>> pathAns;
    std::pair<int, int> cur = std::pair<int, int>{x2, y2};
    while (cur.first != x1 || cur.second != y1) {
        pathAns.push_back(cur);
        cur = paths[cur.first][cur.second];
    }

    std::cout << lens[x2][y2] << std::endl;
    std::cout << x1 << ' ' << y1 << std::endl;
    for (int i = pathAns.size() - 1; i >= 0; i--) {
        std::cout << pathAns[i].first << ' ' << pathAns[i].second << std::endl;
    }

    return 0;
}
 */

fun main() {
    println("Cpp solution")
}