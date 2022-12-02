n = int(input())
d = [1, 2, 4]
for _ in range(n):
    l = len(d)
    num = int(input())
    if num >= l:
        for i in range(l, num + 1):
            d.append(d[i - 1] + d[i - 2] + d[i - 3])
    print(d[num - 1])