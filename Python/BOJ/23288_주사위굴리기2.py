n, m, k = map(int, input().split())
array = [list(map(int, input().split())) for _ in range(n)]
# 동 0 남 1 서 2 북 3
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
d = [0, 1, 2, 3, 4, 5, 6]
x, y, direction, count = 0, 0, 0, 0
result = []
visit = [[0] * m for _ in range(n)]

def init():
    global count, visit
    count = 0
    visit = [[0] * m for _ in range(n)]

def dfs(dice, x, y):
    global count
    if x < 0 or x > n - 1 or y < 0 or y > m - 1:
        return 0
    if array[x][y] == dice and visit[x][y] == 0:
        visit[x][y] = 1
        count += 1
        dfs(dice, x - 1, y) # 상
        dfs(dice, x + 1, y) # 하
        dfs(dice, x, y - 1) # 좌
        dfs(dice, x, y + 1) # 우
        return count
    return 0

for _ in range(k):
    init()
    if not 0 <= x + dx[direction] < n or not 0 <= y + dy[direction] < m:
        direction = (direction + 2) % 4
    x = x + dx[direction]
    y = y + dy[direction]

    if direction == 0: #동
        d[1], d[3], d[4], d[6] = d[4], d[1], d[6], d[3]
    elif direction == 1: #남
        d[1], d[2], d[5], d[6] = d[2], d[6], d[1], d[5]
    elif direction == 2: #서
        d[1], d[3], d[4], d[6] = d[3], d[6], d[1], d[4]
    else: #북
        d[1], d[2], d[5], d[6] = d[5], d[1], d[6], d[2]

    result.append(array[x][y] * dfs(array[x][y], x, y))

    if d[6] > array[x][y]:
        direction = (direction + 1) % 4
    elif d[6] < array[x][y]:
        direction = (direction + 3) % 4


print(sum(result))