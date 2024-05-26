import sys
input = sys.stdin.readline

N, K = map(int, input().split())
if K == 0 or N-K == 0:
    print(1)
    exit()

dp = [0]*1001
dp[1] = 1

for i in range(2, N+1) :
    dp[i] = dp[i-1]*i

print(dp[N] // dp[N-K] // dp[K] % 10007)