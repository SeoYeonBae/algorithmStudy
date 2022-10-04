t = int(input())

for _ in range(t):
    S = input()
    cnt = 1
    result = 0
    for i in S:
        if i == 'O':
            result += cnt
            cnt += 1
        else:
            cnt = 1
    print(result)