import sys

def input() : return sys.stdin.readline().rstrip()

K = int(input())
li = [list(map(int, input().split()))]

cnt = len(li)
for l in li :
    if len(l) == 1 :
        print(l[0], end=" ")
        continue
    mid = len(l)//2
    print(l[mid], end=" ")
    li.append(l[:mid])
    li.append(l[mid+1:])
    if l == li[cnt-1] :
        cnt = len(li)
        print()
