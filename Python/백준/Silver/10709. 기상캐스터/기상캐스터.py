import sys
input = sys.stdin.readline

H, W = map(int, input().split())
arr = [input().rstrip() for _ in range(H)]
ans = [[-1]*W for _ in range(H)]

for i in range(H) :
    if arr[i][0] == "c" :
        ans[i][0] = 0
    for j in range(0, W-1) :
        if arr[i][j+1] == "c" :
            ans[i][j+1] = 0
        elif ans[i][j] != -1 :
            ans[i][j+1] = ans[i][j] + 1

for a in ans :
    print(*a)