# 선택 정렬

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
l = len(array)

for i in range(l):
    min = i
    for j in range(i + 1, l):
        if array[j] < array[min]:
            min = j
    array[i], array[min] = array[min], array[i]

print(array)