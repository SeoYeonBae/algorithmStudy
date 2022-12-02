n = int(input())
array = input().split()
b, c = map(int, input().split())

def directorC(num):
    if num <= c:
        return 1
    else:
        if num % c == 0:
            return (num // c)
        else:
            return (num // c) + directorC(num % c)

def simulation():
    result = 0
    for num in array:
        num = int(num)
        if num <= b:
            result += 1
        else:
            num -= b
            result = result + 1 + directorC(num)
    return result

print(simulation())