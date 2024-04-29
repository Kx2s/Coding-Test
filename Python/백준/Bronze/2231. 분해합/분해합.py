def start(N, max) :
    while max > 0 :
        tmp = N-max
        tl = [int(i) for i in str(tmp)]
        if N == tmp + sum(tl) :
            return tmp

        max -= 1
    return 0

N = int(input())
max = len(str(N)) * 9
if N < max :
    max = N

print(start(N, max))