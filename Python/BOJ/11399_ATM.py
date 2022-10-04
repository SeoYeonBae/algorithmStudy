n = int(input())
data = list(map(int, input().split()))
data.sort()
result = 0
for i in range(n):
    sum = 0
    for j in range(i + 1):
        sum += data[j]
    result += sum
print(result)
