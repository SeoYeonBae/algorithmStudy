array = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

def binary(array, target, start, end):
    if start > end:
        return False
    mid = (start + end) // 2
    if target == array[mid]:
        return True
    elif target > array[mid]:
        return binary(array, target, mid - 1, end)
    elif target < array[mid]:
        return binary(array, target, start, mid + 1)

print(binary(array, 4, 0, len(array) - 1))