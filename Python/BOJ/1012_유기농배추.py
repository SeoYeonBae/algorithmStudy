import sys
sys.setrecursionlimit(10000)

t = int(input())

def dfs(graph, x, y):
    if not 0 <= x < n or not 0 <= y < m:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(graph, x - 1, y)
        dfs(graph, x, y - 1)
        dfs(graph, x + 1, y)
        dfs(graph, x, y + 1)
        return True
    return False

for _ in range(t):
    result = 0
    m, n, k = map(int, input().split())
    graph = [[0 for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        y, x = map(int, input().split())
        graph[x][y] = 1

    for i in range(0, n):
        for j in range(0, m):
            if dfs(graph, i, j):
                result += 1

    print(result)