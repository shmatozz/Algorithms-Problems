package tinkoffAlgorithms2024.w5_strings

/*
#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

const int p = 31;
const int MOD = 1e9 + 9;

int main() {
    string str, substr;
    cin >> str >> substr;
    size_t n = str.length();
    size_t m = substr.length();
    substr += substr;

    vector<int> power_mod(n + 1, 1);
    for (int i = n - 1; i >= 0; --i) {
        power_mod[i] = (1LL * power_mod[i + 1] * p) % MOD;
    }

    vector<int> prefix_hash(n + 1, 0);
    for (int i = 0; i < n; ++i) {
        prefix_hash[i + 1] = (1LL * prefix_hash[i] * p + str[i]) % MOD;
    }

    vector<int> prefix_hash_substr(m * 2 + 1, 0);
    for (int i = 0; i < m * 2; ++i) {
        prefix_hash_substr[i + 1] = (1LL * prefix_hash_substr[i] * p + substr[i]) % MOD;
    }

    set<int> hashes;
    for (int i = 0; i < m; ++i) {
        hashes.insert((1LL * prefix_hash_substr[i + m] - 1LL * prefix_hash_substr[i] * power_mod[power_mod.size() - m - 1] % MOD + MOD) % MOD);
    }

    int count = 0;
    for (int shift : hashes) {
        for (int i = 0; i <= n - m; ++i) {
            int current_hash = (1LL * prefix_hash[i + m] - 1LL * prefix_hash[i] * power_mod[power_mod.size() - m - 1] % MOD + MOD) % MOD;
            if (current_hash == shift) {
                count++;
            }
        }
    }

    cout << count << endl;

    return 0;
}
 */

fun main() {

}