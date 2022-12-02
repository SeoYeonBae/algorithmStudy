n = int(input())
graph = [list(map(int,input())) for _ in range(n)]

num = 0
house = 0
result = []
def dfs(x, y):
    global house
    if not 0 <= x < n or not 0 <= y < n:
        return False
    if graph[x][y] == 1:
        house += 1
        graph[x][y] = 0
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False
for i in range(n):
    for j in range(n):
        if dfs(i, j):
            result.append(house)
            house = 0
            num += 1

print(num)
result.sort()
for i in result:
    print(i)
