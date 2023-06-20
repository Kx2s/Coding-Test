import sys

N, S = map(int, sys.stdin.readline().split())

inn = list(map(int, sys.stdin.readline().split()))
sel = [0] * N
result = 0
def func(ea, num, count) :
    if ea == count :
        if sum(sel) == S :
            global result
            result += 1
            return
        return
        
    for i in range(num, len(inn)) :
        sel[count] = inn[i]
        func(ea, i+1, count + 1)

for i in range(1, len(inn)+ 1) :
    print(i)
    func(i, 0, 0)
print(result)

"""
몇개 고를지부터 반복
뭐 고를지 반복

"""
