import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
dp = arr.copy()

for i in range(N) :
    for j in range(i+1, N) :
        if arr[i] < arr[j] :
            dp[j] = max(dp[j], dp[i] + arr[j])
print(max(dp))