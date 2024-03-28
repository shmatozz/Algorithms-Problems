package tinkoffAlgorithms2024.w5_strings

/*
#include <iostream>
#include <vector>
#include <stack>
#include <set>
#include <algorithm>

int main() {
    std::string s;
    std::getline(std::cin, s);
    s += s;

    int i = 0, ans = 0;
    while (i < s.size() / 2) {
        ans = i;
        int j = i;
        int k = i + 1;

        while (k < s.size() && s[j] <= s[k]) {
            if (s[j] < s[k]) {
                j = i;
            } else {
                j++;
            }
            k++;
        }

        while (i <= j) {
            i += k - j;
        }
    }

    std::cout << s.substr(ans, s.size() / 2) << std::endl;

    return 0;
}
 */

fun main() {

}