n, m = input().split()

n = ''.join(reversed(n))
m = ''.join(reversed(m))

if int(n) > int(m):
    print(n)
else:
    print(m)