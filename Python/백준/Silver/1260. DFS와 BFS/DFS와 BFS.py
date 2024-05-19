import sys
input = sys.stdin.readline

def dfs (v) :
    for l in line[v] :
        if not visited[l] :
            visited[l] = 1
            result.append(l)
            dfs(l)

def bfs (v) :
    stack = [v]
    while stack :
        s = stack[0]
        del stack[0]
        for l in line[s] :
            if not visited[l] :
                visited[l] = 1
                stack.append(l)
                result.append(l)
        


N, M, V = map(int, input().split())
line = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M) :
    i,j = map(int, input().split())
    line[i][j] = 1
    line[j][i] = 1
line = [[i for i in range(len(l)) if l[i] == 1]for l in line]


result = [V]
visited = [0]*(N+1)
visited[V] = 1
dfs(V)
print(*result)

result = [V]
visited = [0]*(N+1)
visited[V] = 1
bfs(V)
print(*result)