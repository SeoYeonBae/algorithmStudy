import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    array = input()
    ans = 0
    for a in array:
        if a == '(':
            ans += 1
        elif a == ')':
            ans -= 1
        if ans < 0:
            break
    if ans == 0:
        print('YES')
    else:
        print('NO')
