n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
info = []
for _ in range(m):
    d, s = map(int, input().split())
    info.append([d - 1, s])
clouds = [[n-2, 0], [n-2, 1], [n-1, 0], [n-1, 1]]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

for dir in info:
    d, s = dir[0], dir[1]
    next_clouds = []
    for cloud in clouds:
        x = cloud[0]
        y = cloud[1]
        nx = (x + dx[d] * s) % n
        ny = (y + dy[d] * s) % n
        next_clouds.append([nx, ny])
    visited = [[False] * n for _ in range(n)]
    for cloud in next_clouds:
        x = cloud[0]
        y = cloud[1]
        a[x][y] += 1
        visited[x][y] = True

    cx = [-1, -1, 1, 1]
    cy = [-1, 1, -1, 1]
    for cloud in next_clouds:
        x = cloud[0]
        y = cloud[1]
        count = 0
        for i in range(4):
            nx = x + cx[i]
            ny = y + cy[i]

            if 0 <= nx < n and 0 <= ny < n and a[nx][ny] >= 1:
                count += 1

        a[x][y] += count

        clouds = []

    for i in range(n):
        for j in range(n):
            if a[i][j] >= 2 and visited[i][j] == False:
                a[i][j] -= 2
                clouds.append([i, j])

ans = 0
for i in range(n):
    ans += sum(a[i])

print(ans)