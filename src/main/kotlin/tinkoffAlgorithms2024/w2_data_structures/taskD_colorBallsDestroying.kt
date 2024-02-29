package tinkoffAlgorithms2024.w2_data_structures

/*
#include <iostream>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }

    std::vector<int> stack;
    int count_balls = 0;

    for (int i = 0; i < n; ++i) {
        if (i == 0 || arr[i] == stack.back()) {
            stack.push_back(arr[i]);
        } else {
            size_t bound = stack.size() - 1;
            while (stack[bound] == stack[bound - 1]) bound--;

            if (stack.size() - bound >= 3) {
                int repeats = stack.size() - bound;
                for (int j = 0; j < repeats; ++j) {
                    stack.pop_back();
                }
                count_balls += repeats;
            }

            stack.push_back(arr[i]);
        }
    }

    size_t bound = stack.size() - 1;
    while (stack[bound] == stack[bound - 1]) bound--;

    if (stack.size() - bound >= 3) {
        int repeats = stack.size() - bound;
        for (int j = 0; j < repeats; ++j) {
            stack.pop_back();
        }
        count_balls += repeats;
    }

    std::cout << count_balls << std::endl;

    delete[] arr;
}
 */

fun main() {
    println("CPP solution above")
}