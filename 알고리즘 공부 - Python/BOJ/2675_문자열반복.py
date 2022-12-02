T = int(input())

for t in range(T):
    result = ''
    R, S = input().split()
    for s in S:
        for r in range(int(R)):
            result += s
    print(result)