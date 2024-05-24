import sys
input = sys.stdin.readline

arr = []
dp = [i for i in range(10001)]

N, D = map(int, input().split())
for _ in range(N) :
    s, e, d = map(int, input().split())
    if e <= D and d < e-s:
        arr.append([s, e, d])
arr.sort(key = lambda x : (x[1], x[0]))

for s,e,d in arr :
    tmp = dp[s] + d
    if dp[e] > tmp :
        dp[e] = tmp
        for i in range(e+1, len(dp)) :
            dp[i] = dp[i-1] + 1

print(dp[D])