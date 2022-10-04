# gcd 최대공약수 lcm 최소공배수

from math import gcd

# 최대 공약수
print('최대 공약수: ', gcd(192, 162))

# 최소 공배수
def lcm(a, b):
    return a * b // gcd(a, b)

print('최소 공배수: ', lcm(192, 162))

# 여러 수의 최소 공배수

def solution(arr):
    def lcm(x, y):
        return x * y // gcd(x, y)

    while True:
        arr.append(lcm(arr.pop(), arr.pop()))
        if len(arr) == 1:
            return arr[0]


print('여러 수의 최소 공배수: ', solution([2, 6, 8, 14]))