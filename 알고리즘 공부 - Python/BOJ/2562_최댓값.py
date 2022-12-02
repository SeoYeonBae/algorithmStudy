array = [int(input()) for _ in range(9)]
max = max(array)

for i in range(9):
    if array[i] == max:
        print(max)
        print(i + 1)
        break