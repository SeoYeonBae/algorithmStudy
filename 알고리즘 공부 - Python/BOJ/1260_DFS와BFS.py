from collections import deque

n, m, v = map(int, input().split())
graph = [[0 for i in range(n + 1)] for j in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1
visited = [False] * (n + 1)

def DFS(graph, visited, k):
    print(k, end=' ')
    visited[k] = True
    for i in range(1, n + 1):
        if not visited[i] and graph[k][i] == 1:
            DFS(graph, visited, i)

def BFS(graph, visited, k):
    q = deque([k])
    visited[k] = True
    while q:
        que = q.popleft()
        print(que, end=' ')
        for i in range(1, n + 1):
            if graph[que][i] == 1 and not visited[i]:
                q.append(i)
                visited[i] = True

DFS(graph, visited, v)
print()
visited = [False] * (n + 1)
BFS(graph, visited, v)