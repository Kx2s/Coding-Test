import sys
input = sys.stdin.readline

N = int(input())
result = [11]*N
arr = list(map(int, input().split()))
for i in range(N) :
    cnt = 0
    for j in range(0, N) :
        if result[j] == 11 and arr[i] == cnt :
            result[j] = i+1
            break
        if result[j] > i+1 :
            cnt += 1
print(*result)