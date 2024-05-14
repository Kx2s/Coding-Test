import sys
input = sys.stdin.readline

N, X = map(int, input().split())

arr = list(map(int, input().split()))
dp = [0] * (N)

for i in range(N) :
    dp[i] = dp[i-1] + arr[i]

for i in range(N-1, X-1, -1) :
    dp[i] -= dp[i-X]

mx = max(dp[X-1:])
print("SAD" if mx == 0 else f'{mx}\n{dp[X-1:].count(mx)}')