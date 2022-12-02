n = int(input())
ss = list(map(int, input().split()))

result = []
m = max(ss)

for s in ss:
    result.append((s/m)*100)
print(sum(result)/n)