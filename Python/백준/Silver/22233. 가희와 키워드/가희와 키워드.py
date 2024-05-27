import sys
input = sys.stdin.readline

N, M = map(int, input().split())
keyword = {input().rstrip():True for _ in range(N)}
blog = [list(input().rstrip().split(",")) for _ in range(M)]

for b in blog :
    for i in range(len(b)) :
        if keyword.get(b[i], False) :
            del keyword[b[i]]
    print(len(keyword))