"""# 최소힙
import heapq

def heapsort(iterable):
    h = []
    result = []

    for value in iterable:
      heapq.heappush(h,value)

    for i in range(len(h)):
      result.append(heapq.heappop(h))

    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result)

# 최대힙
def heapsort(iterable):
    h = []
    result = []

    for value in iterable:
      heapq.heappush(h,-value)

    for i in range(len(h)):
      result.append(-heapq.heappop(h))

    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result)
"""
# 힙 자료구조를 이용한 다익스트라 알고리즘
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n+1)]
distance = [INF] * (n+1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
        if cost < distance[i[0]]:
            distance[i[0]] = cost
            heapq.heaqpush(q,(cost,i[0]))

dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
      print("INFINITY")
    else:
      print(distance[i])