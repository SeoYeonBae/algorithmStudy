# CLASS_2 2292 벌집

N = int(input())
start = 1
num = 1
while N > start:
    start += num * 6
    num += 1

print(num)