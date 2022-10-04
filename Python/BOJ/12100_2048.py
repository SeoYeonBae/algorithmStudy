from collections import deque

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

answer = 0
q = deque()

def solve(count):
    global  graph, answer
    if count == 5:
        for i in range(n):
            answer = max(answer, max(graph[i]))
        return
    b = [x[:] for x in graph]
    for k in range(4):
        move(k)
        solve(count + 1)
        graph = [x[:] for x in b]

def get(i, j):
    if graph[i][j]: # 0이 아닌 값이라면
        q.append(graph[i][j]) # queue에 graph의 값을 넣는다.
        graph[i][j] = 0 # 처리가 된 빈 자리는 0으로 값 업데이트

def move(k):
    # graph[i][j]
    if k == 0: # 위로 이동, 블락들이 위로 모두 이동하면 row index는 0
        for j in range(n):
            for i in range(n):
                get(i, j)
            merge(0, j, 1, 0) # row index 1씩 증가하면서 아래쪽 블락들을 합쳐감
    elif k == 1: # 아래로 이동, 블락들이 아래로 모두 이동하면 row index는 n-1
        for j in range(n):
            for i in range(n-1, -1, -1):
                get(i, j)
            merge(n-1, j, -1, 0) # row 인덱스 1씩 감소하면서 위쪽들을 합쳐감
    elif k == 2: # 오른쪽으로 이동, column index는 0
        for i in range(n):
            for j in range(n):
                get(i, j)
            merge(i, 0, 0, 1) # column 인덱스 증가 오른쪽으로 이동
    else: # 왼쪽으로 이동, column index는 n-1
        for i in range(n):
            for j in range(n-1, -1, -1):
                get(i, j)
            merge(i, n-1, 0, -1) # column 인덱스 감소 왼쪽으로 이동
def merge(i, j, di, dj): # row index, column index, y방향, x방향
    while q:
        x = q.popleft() # 움직이려는 블록 값을 가져온다. FIFO
        if not graph[i][j]: # 0이라면 그대로 놓는다.
            graph[i][j] = x
        elif graph[i][j] == x: # 값이 일치한다면
            graph[i][j] = x*2 # 합쳐지므로 2배로 증가
            i, j = i+di, j+dj
        else: # 값이 일치하지 않으면
            i, j = i+di, j+dj
            graph[i][j] = x

solve(0)
print(answer)