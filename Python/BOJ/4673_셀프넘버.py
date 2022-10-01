n = set(range(1, 10001))
g = set()

for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    g.add(i)

self = sorted(n - g)
for i in self:
    print(i)