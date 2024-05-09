import sys
def input() : return sys.stdin.readline()

def start() :
    rank = list(map(int,input().split()))
    
    if score == min(rank) and N==P:
        print(-1)
        return
    
    cnt = -1
    for i in range(P) :
        if len(rank) == i :
            cnt = i + 1
            break
        
        if score >= rank[i] :
            cnt = i + 1
            break
    print(cnt)


N, score, P = map(int, input().split())
if N == 0 :
    print(1)
else:
    
    start()