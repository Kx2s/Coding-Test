import sys
input = sys.stdin.readline

mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

N = int(input())
visit = [[0]*N for _ in range(N)]
arr = [list(input().rstrip()) for i in range(N)]
ans = []

def dfs (y, x, cnt) :
    cnt += 1
    visit[y][x] = 1
    for i in range(4) :
        dy = my[i] + y
        dx = mx[i] + x
        if 0<=dy<N and 0<=dx<N and int(arr[dy][dx]) and not visit[dy][dx] :
            cnt = dfs(dy,dx, cnt)
    return cnt

for i in range(N) :
    for j in range(N) :
        if int(arr[i][j]) and not visit[i][j] :
            ans.append(dfs(i, j, 0))
ans.sort()
print(len(ans))
for a in ans :
    print(a)