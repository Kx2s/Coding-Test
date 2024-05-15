import sys
from collections import deque
input = sys.stdin.readline

mx = [-2,-1, 1, 2, 2, 1,-1,-2]
my = [ 1, 2, 2, 1,-1,-2,-2,-1]

for T in range(int(input())) :
    I = int(input())
    now = list(map(int, input().split()))
    Q = list(map(int, input().split()))
    
    visit = [[0]*I for _ in range(I)]

    que = deque()
    que.append([now, 0])


    while que :
        tmp,cnt = que.popleft()
        if tmp == Q :
            print(cnt)
            break

        for i in range(8) :
            dy = tmp[0] + my[i]
            dx = tmp[1] + mx[i]
            if 0<=dy<I and 0<=dx<I and visit[dy][dx] == 0 :
                visit[dy][dx] = 1
                que.append([[dy,dx],cnt+1])