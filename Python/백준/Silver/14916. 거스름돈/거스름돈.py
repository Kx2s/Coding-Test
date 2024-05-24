import sys
input = sys.stdin.readline

n = int(input())
if n in [1,3] :
    print(-1)
    exit()
dp = [100] * 100001
dp[2] = 1
dp[4] = 2
dp[5] = 1

for i in range(6, len(dp)) :
    dp[i] = min(dp[i-2]+1, dp[i-5] + 1)
print(dp[n])