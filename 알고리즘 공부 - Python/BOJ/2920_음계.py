music = list(map(int, input().split()))

result = ''

if music == sorted(music):
    result = 'ascending'
elif music == sorted(music, reverse=True):
    result = 'descending'
else:
    result = 'mixed'

print(result)