import math
m, n = map(int, input().split())

def prime(num):
    if num == 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

for o in range(m, n + 1):
    if prime(o):
        print(o)