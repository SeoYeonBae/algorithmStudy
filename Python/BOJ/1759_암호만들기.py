from itertools import combinations

L, C = map(int, input().split())
password = list(input().split())
password.sort()
vowel = ['a', 'e', 'i', 'o', 'u']
result = combinations(password, L)
for i in result:
    v, c = 0, 0
    for j in i:
        if j in vowel:
            v += 1
        else:
            c += 1
    if v >= 1 and c >= 2:
        print(''.join(i))