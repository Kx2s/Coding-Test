import sys
input = sys.stdin.readline

N, C = map(int, input().split())
arr = list(map(int, input().split()))
dic = {}
li = [[] for _ in range(N+1)]
result = []
for a in arr :
    if dic.get(a) :
        dic[a] += 1
    else :
        dic[a] = 1

for k, v in dic.items() :
    li[v].append(k)

while li :
    p = li.pop()
    if len(p) == 1 :
        for _ in range(len(li)) :
            result.append(p[0])
    else :
        for a in arr :
            if a in p :
                p.remove(a)
                for _ in range(len(li)) :
                    result.append(a)
                if not p :
                    break

print(*result)