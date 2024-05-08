import sys
def input() : return sys.stdin.readline()

dp = [0]*int(input())
li = list(map(int, input().split()))
dp[0] = li[0]

for i in range(1, len(li)) :
    dp[i] = max(dp[i-1]+li[i], li[i])
print(max(dp))