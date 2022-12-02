import math

def prime(num):
    if num == 1:
        return True
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

n = int(input())
while n != 0:
    result = 0
    for i in range(n + 1, 2 * n + 1):
        if prime(i):
            result += 1
    print(result)
    n = int(input())