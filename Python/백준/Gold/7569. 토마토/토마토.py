import sys
from collections import deque
def input() : return sys.stdin.readline()

def start() :
    day = 0
    lenght = len(queue)

    while queue :
        if lenght == 0 :
            day+= 1
            lenght = len(queue)
        h, n, m = queue.popleft()

        for mo in move :
            mh = h+mo[0]; mn = n+mo[1]; mm = m+mo[2]
            if 0<=mh<H and 0<=mn<N and 0<=mm<M and arr[mh][mn][mm] == 0 :
                arr[mh][mn][mm] = 1
                queue.append([mh, mn, mm])
        lenght-= 1
    
    for h in arr:
        for n in h :
            if 0 in n :
                return -1
    return day

M, N, H = map(int, input().split())

arr = []
queue  = deque()
move = [[0, 0, 1], [0, 0, -1], [0, 1, 0], [0, -1, 0], [1, 0, 0], [-1, 0, 0]]

for h in range(H) :
    arr.append([])
    for n in range(N) :
        tmp = list(map(int, input().split()))
        arr[h].append(tmp)
        if 1 in tmp :
            for i in range(len(tmp)) :
                if tmp[i] == 1 :
                    queue.append([h,n,i])

print(start())