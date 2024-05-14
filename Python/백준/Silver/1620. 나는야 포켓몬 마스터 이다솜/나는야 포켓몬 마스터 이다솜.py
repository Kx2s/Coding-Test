import sys
input = sys.stdin.readline

N, M = map(int, input().split())

wiki = {}
for i in range(1,N+1) :
    tmp = input().rstrip()
    wiki[tmp] = i
    wiki[f"{i}"] = tmp

for _ in range(M) :
    Q = input().rstrip()
    print(wiki.get(Q))