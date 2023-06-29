import sys
input = sys.stdin.readline

n, k = map(int, input().split())

money = []
for _ in range(n) :
    money.append(int(input().rstrip()))

dp = [0] * (k + 1)
dp[0] = 1

for i in range(n) :
    for j in range(money[i], k + 1) :
        dp[j] = dp[j] + dp[j - money[i]]

print(dp[k])
