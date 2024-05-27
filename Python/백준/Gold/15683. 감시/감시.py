import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
cctvs = []
visit = [[0]*M for _ in range(N)]
m = [[-1,0], [0,1], [1,0], [0,-1]]
vec = [[], [[0],[1],[2],[3]], [[0,2],[1,3]], [[0,1],[1,2],[2,3],[3,0]], [[0,1,2],[1,2,3],[2,3,0],[3,0,1]], [[0,1,2,3]]]

for i in range(N) :
    arr.append(list(map(int, input().split())))
    for j in range(M) :
        if arr[i][j] != 0 :
            visit[i][j] = 1
            if arr[i][j] != 6 :
                cctvs.append([i,j])

def visible (y,x,num, value) :
    dy = y+m[num][0]
    dx = x+m[num][1]
    if 0<=dx<M and 0<=dy<N and arr[dy][dx] != 6 :
        visit[dy][dx] += value
        visible(dy,dx,num,value)

def start (cctvs) :
    if len(cctvs) == 0 :
        result = 0
        for v in visit :
            result += v.count(0)
        return result
    
    result = M*N
    for V in vec[arr[cctvs[0][0]][cctvs[0][1]]] :
        for v in V :
            visible(cctvs[0][0], cctvs[0][1], v, 1)
        result = min(result, start(cctvs[1:]))
        for v in V :
            visible(cctvs[0][0], cctvs[0][1], v, -1)
    return result

print(start(cctvs))