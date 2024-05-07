import sys
def input() : return sys.stdin.readline()

N, M, K = map(int, input().split())
li = []

for _ in range(K) :
    li.append(list(map(int, input().split())))

result = 0
while len(li) > 0 :
    l = li[0]
    li.remove(l)
    stack = [l]
    for s in stack :
        for l in li.copy() :
            if abs(l[0] - s[0]) + abs(l[1] - s[1]) == 1 :
                stack.append(l)
                li.remove(l)
    
    result = max(result,len(stack))
print(result)