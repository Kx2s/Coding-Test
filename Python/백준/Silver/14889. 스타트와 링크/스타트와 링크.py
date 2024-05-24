import sys
input = sys.stdin.readline

N = int(input())
arr = []
for _ in range(N) :
    tmp = list(map(int, input().split()))
    arr.append(tmp)
ans = 100 * N/2

def start(idx, li) :
    if len(li) == N//2 :
        global ans
        result = 0
        li_l = [i for i in range(N) if i not in li]
        for i in range(N//2) :
            for j in range(N//2) :
                result += arr[li[i]][li[j]]
                result -= arr[li_l[i]][li_l[j]]
        ans = min(abs(result), ans)
        return
    
    for i in range(idx, N) :
        if i not in li :
            start(i+1, li+[i])

start(1, [0])
print(ans)