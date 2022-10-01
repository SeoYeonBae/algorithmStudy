import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
queue = deque()

for i in range(n):
    dir = input().split()
    if dir[0] == 'push':
        queue.append(int(dir[1]))
    elif dir[0] == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue.popleft())
    elif dir[0] == 'size':
        print(len(queue))
    elif dir[0] == 'empty':
        if not queue:
            print(1)
        else:
            print(0)
    elif dir[0] == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])
    elif dir[0] == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])