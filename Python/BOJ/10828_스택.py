import sys
input = sys.stdin.readline
n = int(input())
s = []
for i in range(n):
    dir = input().split()
    if dir[0] == 'push':
        s.append(int(dir[1]))
    elif dir[0] == 'pop':
        if not s:
            print(-1)
        else:
            print(s.pop())
    elif dir[0] == 'size':
        print(len(s))
    elif dir[0] == 'empty':
        if not s:
            print(1)
        else:
            print(0)
    else:
        if not s:
            print(-1)
        else:
            print(s[-1])