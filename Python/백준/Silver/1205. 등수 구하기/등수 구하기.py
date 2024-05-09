import sys
def input() : return sys.stdin.readline()

def start() :
    rank = list(map(int,input().split()))
    
    if score == min(rank) and N==P:
        return -1
    
    for i in range(P) :
        if len(rank) == i :
            return i + 1
        
        elif score >= rank[i] :
            return i + 1
    return -1

N, score, P = map(int, input().split())
if N == 0 :
    print(1)

else :
    print(start())