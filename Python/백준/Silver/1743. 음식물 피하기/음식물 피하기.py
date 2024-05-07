#다른 방식
import sys
sys.setrecursionlimit(10**6)

def input() : return sys.stdin.readline()

def dfs (x, y) :
    visit[y][x] = 1
    global size
    size += 1

    for mx, my in [[-1,0],[1,0],[0,-1],[0,1]] :
        lx = x+mx; ly = y+my
        if [lx,ly] in trash :
            if not visit[ly][lx]:
                dfs(lx,ly)

N, M, K = map(int, input().split())

visit = [[0]*M for _ in range(N)]
trash = []
result = 0

for _ in range(K) :
    y,x = map(int, input().split())
    trash.append([x-1,y-1])

for x, y in trash :
    if not visit[y][x] :
        size = 0
        dfs(x, y)
        result = max(result, size)

print(result)