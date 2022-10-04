n = int(input())
array = []
for _ in range(n):
    time_1, time_2 = map(int, input().split())
    array.append((time_1, time_2))

array = sorted(array, key=lambda time:time[0])
array = sorted(array, key=lambda time:time[1])

last, cnt = 0, 0
for i in range(n):
    if array[i][0] >= last:
        cnt += 1
        last = array[i][1]

print(cnt)