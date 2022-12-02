import sys
input = sys.stdin.readline

n = int(input())

def group(world):
    ans = []
    for w in str(world):
        if w not in ans:
            ans.append(w)
        else:
            if ans[-1] == w:
                ans.append(w)
            else:
                return False
    return True

result = 0

for i in range(n):
    array = input()
    if group(array):
        result += 1

print(result)