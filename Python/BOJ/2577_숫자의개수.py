array = [int(input()) for _ in range(3)]
result = [0 for _ in range(10)]
num = 1
for a in array:
    num *= a
num = str(num)
for n in num:
    result[int(n)] +=1
for r in result:
    print(r)