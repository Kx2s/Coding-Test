import sys

N, K = map(int, sys.stdin.readline().split())
W = []
V = []
dp = [[0] * (K+1) for _ in range(N+1)]
for i in range(1, N+1):
    w, v = map(int , sys.stdin.readline().split())
    W.append(w)
    V.append(v)

for i in range(1, len(dp)) :
    for j in range(1, len(dp[i])) :
        if j >= W[i-1]:
            dp[i][j] = max(V[i-1] + dp[i-1][j-W[i-1]], dp[i-1][j])
        else :
            dp[i][j] = dp[i-1][j]

print(dp[N][K])