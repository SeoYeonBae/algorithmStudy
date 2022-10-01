n, x = map(int, input().split())
array = list(map(int, input().split()))
result = []
for a in array:
    if a < x:
        result.append(a)

for r in result:
    print(r, end=' ')