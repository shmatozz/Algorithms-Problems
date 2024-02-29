package tinkoffAlgorithms2024.w2_data_structures

//#include <iostream>
//#include <vector>
//
//int main() {
//    int n;
//    std::cin >> n;
//    int *arr = new int[n];
//    for (int i = 0; i < n; ++i) {
//        std::cin >> arr[i];
//    }
//
//    std::vector<int> stack;
//    std::vector<int> operations;
//    std::vector<int> counts;
//    int require = 0;
//    int i = 0;
//    int count = 0;
//
//    while (i < n) {
//        while (i < n && (stack.empty() || stack.back() > arr[i])) {
//            stack.push_back(arr[i]);
//            i++;
//            count++;
//        }
//        if (count != 0) {
//            operations.push_back(1);
//            counts.push_back(count);
//            count = 0;
//        } else {
//            break;
//        }
//
//        while (i < n && !stack.empty() && stack.back() < arr[i] && stack.back() == require + 1) {
//            stack.pop_back();
//            count++;
//            require++;
//        }
//        if (count != 0) {
//            operations.push_back(2);
//            counts.push_back(count);
//            count = 0;
//        } else {
//            break;
//        }
//    }
//
//    while (!stack.empty() && stack.back() == require + 1) {
//        stack.pop_back();
//        count++;
//        require++;
//    }
//    operations.push_back(2);
//    counts.push_back(count);
//
//    if (!stack.empty()) {
//        std::cout << 0 << std::endl;
//    } else {
//        std::cout << operations.size() << std::endl;
//        for (i = 0; i < operations.size(); ++i) {
//            std::cout << operations[i] << ' ' << counts[i] << std::endl;
//        }
//    }
//
//    delete[] arr;
//}

fun main() {
    println("CPP solution above")
}
