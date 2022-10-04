word = input().upper()
unique = list(set(word))
cnt = []

for i in unique:
    count = word.count(i)
    cnt.append(count)

if cnt.count(max(cnt)) > 1:
    print('?')
else:
    print(unique[cnt.index(max(cnt))])
