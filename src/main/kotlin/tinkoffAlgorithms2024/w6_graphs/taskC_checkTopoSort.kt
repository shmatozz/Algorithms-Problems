package tinkoffAlgorithms2024.w6_graphs

/*
#include <iostream>
#include <vector>
#include <stack>
#include <set>
#include <algorithm>

bool flag = true;

void dfs(std::vector<std::set<int>>& graph, int start, std::vector<int>& visited) {
    visited[start] = visited[0];
    visited[0]++;
    for (int next : graph[start]) {
        if (visited[next] == -1) {
            dfs(graph, next, visited);
        } else if (visited[next] < visited[start]) {
            flag = false;
        }
    }
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

    std::vector<int> seq(n);
    std::vector<int> sort(n);
    std::vector<int> visited(n + 1, -1);
    visited[0] = 1;
    for (int i = 0; i < n; ++i) {
        std::cin >> seq[i];
        visited[seq[i]] = visited[0];
        visited[0]++;
    }

    for (int v = 1; v <= n; v++) {
        for (auto u : graph[v]) {
            if (visited[v] > visited[u]) {
                flag = false;
            }
        }
    }

    if (flag) {
        std::cout << "YES" << std::endl;
    } else {
        std::cout << "NO" << std::endl;
    }
    return 0;
}
 */

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val graph: Array<MutableSet<Int>> = Array(n + 1) { mutableSetOf() }
    for (i in 0 until m) {
        val (from, to) = readln().split(' ').map { it.toInt() }
        graph[from].add(to)
    }

    val seq = readln().split(' ').map { it.toInt() }.toIntArray()
    val visited = IntArray(n + 1) { 1 }
    for (i in 0 until n) {
        visited[seq[i]] = visited[0]
        visited[0]++
    }

    var flag = true
    for (v in 1..n) {
        for (u in graph[v]) {
            if (visited[v] > visited[u]) {
                flag = false
            }
        }
    }

    if (flag) {
        println("YES")
    } else {
        println("NO")
    }
}