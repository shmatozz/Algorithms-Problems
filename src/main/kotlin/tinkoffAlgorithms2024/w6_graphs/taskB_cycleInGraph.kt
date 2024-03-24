package tinkoffAlgorithms2024.w6_graphs

/*
#include <iostream>
#include <vector>
#include <stack>
#include <set>
#include <algorithm>

void dfs(std::vector<std::set<int>>& graph, int start, std::vector<int>& inComponent) {
    inComponent[start] = 1;

    for (int next : graph[start]) {
        if (inComponent[next] == 0) {
            dfs(graph, next, inComponent);
        } else if (inComponent[next] == 1) {
            inComponent[0] = 1;
        }
    }

    inComponent[start] = 2;
}

int main() {
    int n, m;
    std::cin >> n >> m;
    std::vector<std::set<int>> graph(n + 1);

    for (int i = 0; i < m; ++i) {
        int from, to;
        std::cin >> from >> to;
        graph[from].insert(to);
    }

    std::vector<int> inComponent(n + 1, 0);

    for (int v = 1; v < graph.size(); ++v) {
        if (inComponent[v] == 0) {
            dfs(graph, v, inComponent);
        }
    }

    std::cout << inComponent[0] << std::endl;
    return 0;
}
 */

fun main() {
    println("Again cpp solution")
}
