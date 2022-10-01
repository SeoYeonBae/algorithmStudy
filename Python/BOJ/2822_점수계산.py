num = []
for _ in range(8):
    num.append(int(input()))

results = sorted(num, reverse=True)[0:5]
print(sum(results))

indexs = []
for result in results:
    indexs.append(num.index(result))
indexs.sort()
for i in indexs:
    print(i + 1, end=' ')