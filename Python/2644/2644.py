import sys

n = int(sys.stdin.readline())
Q = list(map(int, sys.stdin.readline().split()))
rel = []
check = []

for _ in range(int(sys.stdin.readline())) :
    rel.append(list(map(int, sys.stdin.readline().split())))

def func(a) :
    check.append(a)
    for i in rel :
        if a == i[1] :
            return func(i[0]) + 1
    return 1

result1 = func(Q[0])
result2 = func(Q[1])
result = result1 + result2
check2 = list(set(check))
ch = len(check) - len(check2)
if ch == 0:
    print(-1)

else :
    print(result - (ch*2))






"""
0으로 깊이탐색
있다면 앞으로 없으면 -1 리턴
"""



