n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
coins.sort(reverse=True)

result = 0
for coin in coins:
    result += k // coin
    k = k % coin
print(result)