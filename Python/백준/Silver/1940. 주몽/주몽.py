import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
arr = list(map(int, input().split()))
sor = [0] * 100000
li = []
ans = 0

for a in arr :
    sor[a] += 1
for i in range(len(sor)) :
    if sor[i] != 0 :
        for _ in range(sor[i]) :
            li.append(i)
e = len(li)

for i in range(len(li)) :
    for j in range(e-1, i, -1) :
        if li[i] + li[j] == M:
            ans +=1
            e = j
            break
        elif li[i] + li[j] < M :
            e = j + 1
            break

print(ans)