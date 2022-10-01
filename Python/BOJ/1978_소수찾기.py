import math

n = int(input())
array = list(map(int, input().split()))

result = 0

def prime(x):
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

for a in array:
    if a == 1:
        continue
    if prime(a):
        result += 1

print(result)

