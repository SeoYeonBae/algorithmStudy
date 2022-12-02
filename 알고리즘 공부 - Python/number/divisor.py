# 약수 찾기

import math

def find_all_divisors(x):
    result = []
    for i in range(1, int(math.sqrt(x)) + 1):
        if x % i == 0:
            result.append(i)
            if i * i != x:
                result.append(x // i)
    return result

print(find_all_divisors(12))