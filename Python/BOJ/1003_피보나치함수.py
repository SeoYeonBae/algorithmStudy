n = int(input())
count_0 = [1, 0, 1]
count_1 = [0, 1, 1]

def fibo(n):
    if n >= len(count_1):
        l = len(count_1)
        for i in range(l, n + 1):
            count_0.append(count_1[i - 1])
            count_1.append(count_0[i - 1] + count_1[i - 1])
    print(count_0[n], count_1[n])

for i in range(n):
    num = int(input())
    fibo(num)