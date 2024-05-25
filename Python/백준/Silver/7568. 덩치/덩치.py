import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = [1]*N

for i in range(N) :
    for kg, cm in arr :
        if arr[i][0] < kg and arr[i][1] < cm :
            ans[i] += 1
print(*ans)