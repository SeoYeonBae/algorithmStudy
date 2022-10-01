a = list(map(int, input().split()))
result = 0
for i in a:
    result += i*i
print(result % 10)