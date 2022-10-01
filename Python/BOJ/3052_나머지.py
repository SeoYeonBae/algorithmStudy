a = []

for _ in range(10):
    n = int(input())
    a.append(n % 42)

result = set(a)
print(len(result))