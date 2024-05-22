import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

def check (y, x):
    visit[y][x] = 1
    for i in range(4) :
        dx = x + mx[i]
        dy = y + my[i]
        if 0<=dy<N and 0<=dx<M and (not visit[dy][dx]) and arr[dy][dx] :
            check(dy, dx)

for T in range(int(input())) :
    M, N, K = map(int, input().split())
    
    ans = 0
    arr = [[0]*M for _ in range(N)]
    visit = [[0]*M for _ in range(N)]

    for _ in range(K) :
        x, y = map(int, input().split())
        arr[y][x] = 1

    for i in range(N) :
        for j in range(M) :
            if not visit[i][j] and arr[i][j]:
                check(i, j)
                ans += 1
                
    print(ans)