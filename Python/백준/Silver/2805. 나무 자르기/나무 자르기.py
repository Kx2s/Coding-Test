import sys
input = sys.stdin.readline

N, M = map(int, input().split())
wood = list(map(int, input().split()))
dic = {}
for w in wood :
    v = dic.get(w,0)
    dic[w] = v+1
li = list(dic.keys())
li.sort()

cnt = 0
mx = li[-1]
while M > 0:
    cnt += dic[mx]
    dic.pop(mx)
    li.pop()
    
    dx = 0 if not dic else li[-1]
    tmp = (mx - dx) * cnt
    
    if tmp < M :
        M -= tmp
        mx = dx
    else :
        print(int(mx - M/cnt))
        break