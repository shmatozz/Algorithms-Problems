package tinkoffAlgorithms2024.w13_final_exam

/*
MOD = 10 ** 9 + 9


def is_prime(num):
    if num <= 1:
        return False
    if num <= 3:
        return True
    if num % 2 == 0 or num % 3 == 0:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if (num % i) == 0:
            return False
    return True


n = int(input())

prime_triplets = []
for i in range(1, 1000):
    if is_prime(i):
        prime_triplets.append(i)
triplet_strs = [str(p) for p in prime_triplets]

for i in range(len(triplet_strs)):
    if len(triplet_strs[i]) == 1:
        triplet_strs[i] = '00' + triplet_strs[i]
    elif len(triplet_strs[i]) == 2:
        triplet_strs[i] = '0' + triplet_strs[i]
    else:
        break

dp = [[0] * 1000 for _ in range(n + 1)]

for triplet in triplet_strs:
    dp[3][int(triplet)] = 1

for i in range(4, n + 1):
    for triplet in triplet_strs:
        suffix = triplet[1:]
        for digit in '0123456789':
            new_triplet = suffix + digit
            if int(new_triplet) in prime_triplets:
                dp[i][int(new_triplet)] = (dp[i][int(new_triplet)] + dp[i - 1][int(triplet)]) % MOD

result = 0
for triplet in triplet_strs:
    result = (result + dp[n][int(triplet)]) % MOD

print(result)
 */

fun main() {

}