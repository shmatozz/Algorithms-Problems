package tinkoffAlgorithms2024.w8_segmentTrees

/*
#include <iostream>
#include <vector>

void buildEmptyTree(std::vector<long long>& tree, std::vector<long long>& array, int cur, int leftIndex, int rightIndex) {
    if (leftIndex == rightIndex) {
        tree[cur] = array[leftIndex];
        return;
    }

    int mid = (leftIndex + rightIndex) / 2;
    buildEmptyTree(tree, array, cur * 2, leftIndex, mid);
    buildEmptyTree(tree, array, cur * 2 + 1, mid + 1, rightIndex);

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];
}

void add(std::vector<long long>& tree, int cur, int leftIndex, int rightIndex, int start, int end, long long value) {
    if (start == leftIndex && rightIndex == end) {
        tree[cur] = value;
        return;
    }

    if (rightIndex < start || end < leftIndex) {
        return;
    }

    int mid = (leftIndex + rightIndex) / 2;
    add(tree, cur * 2, leftIndex, mid, start, end, value);
    add(tree, cur * 2 + 1, mid + 1, rightIndex, start, end, value);

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];
}

long long get(std::vector<long long>& tree, int cur, int leftIndex, int rightIndex, int start, int end) {
    if (start > end) {
        return 0;
    }

    if (start <= leftIndex && rightIndex <= end) {
        return tree[cur];
    }

    int mid = (leftIndex + rightIndex) / 2;
    return get(tree, cur * 2, leftIndex, mid, start, std::min(end, mid)) + get(tree, cur * 2 + 1, mid + 1, rightIndex, std::max(start, mid + 1), end);
}

int main() {
    std::ios_base::sync_with_stdio(false);std::cin.tie(NULL);std::cout.tie(NULL);

    int n, m;
    std::cin >> n >> m;

    std::vector<long long> array(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> array[i];
    }

    std::vector<long long> tree(n * 4);
    buildEmptyTree(tree, array, 1, 0, n - 1);

    for (int i = 0; i < m; ++i) {
        int op, first, second;
        std::cin >> op >> first >> second;

        if (op == 1) {
            add(tree, 1, 0, n - 1, first, first, second);
        } else if (op == 2) {
            std::cout << get(tree, 1, 0, n - 1, first, second - 1) << std::endl;
        }
    }

    return 0;
}
 */

fun buildEmptyTree(tree: LongArray, array: LongArray, cur: Int, leftIndex: Int, rightIndex: Int) {
    if (leftIndex == rightIndex) {
        tree[cur] = array[leftIndex]
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    buildEmptyTree(tree, array, cur * 2, leftIndex, mid)
    buildEmptyTree(tree, array, cur * 2 + 1, mid + 1, rightIndex)

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1]
}

fun add(tree: LongArray, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int, value: Long) {
    if (start == leftIndex && rightIndex == end) {
        tree[cur] = value
        return
    }

    if (rightIndex < start || end < leftIndex) {
        return
    }

    val mid = (leftIndex + rightIndex) / 2
    add(tree, cur * 2, leftIndex, mid, start, end, value)
    add(tree, cur * 2 + 1, mid + 1, rightIndex, start, end, value)

    tree[cur] = tree[cur * 2] + tree[cur * 2 + 1]
}

fun get(tree: LongArray, cur: Int, leftIndex: Int, rightIndex: Int, start: Int, end: Int): Long {
    if (start > end) {
        return 0
    }

    if (start <= leftIndex && rightIndex <= end) {
        return tree[cur]
    }

    val mid = (leftIndex + rightIndex) / 2
    return get(tree, cur * 2, leftIndex, mid, start, minOf(end, mid)) + get(tree, cur * 2 + 1, mid + 1, rightIndex, maxOf(start, mid + 1), end)
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val array = readln().split(' ').map { it.toLong() }.toLongArray()

    val tree = LongArray(n * 4)
    buildEmptyTree(tree, array, 1, 0, n - 1)

    repeat(m) {
        val (op, first, second) = readln().split(' ').map { it.toInt() }

        if (op == 1) {
            add(tree, 1, 0, n - 1, first, first, second.toLong())
        } else if (op == 2) {
            println(get(tree, 1, 0, n - 1, first, second - 1))
        }
    }
}
