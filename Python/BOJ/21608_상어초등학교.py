n = int(input())
students = [list(map(int, input().split())) for _ in range(n*n)]
classroom = [[0] * n for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for num in range(n*n):
    student = students[num]
    tmp = []
    for i in range(n):
        for j in range(n):
            if classroom[i][j] == 0:
                like = 0
                blank = 0
                for k in range(4):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 <= nx < n and 0 <= ny < n:
                        if classroom[nx][ny] in student[1:]:
                            like += 1
                        if classroom[nx][ny] == 0:
                            blank += 1
                tmp.append([like, blank, i, j])
    tmp.sort(key= lambda x:(-x[0], -x[1], x[2], x[3]))
    classroom[tmp[0][2]][tmp[0][3]] = student[0]

result = 0

for student in students:
    s = 0
    for i in range(n):
        for j in range(n):
            if classroom[i][j] == student[0]:
                for k in range(4):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 <= nx < n and 0 <= ny < n:
                        if classroom[nx][ny] in student[1:]:
                            s += 1
    if s != 0:
        result = result + 10**(s-1)

print(result)