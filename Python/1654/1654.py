import sys

K, N = map(int, sys.stdin.readline().split())
cm = []
for i in range(K) :
    cm.append(int(sys.stdin.readline()))

stand = sum(cm) // N

def func(start, end) :
    if start > end :
        return 1

    count = 0
    mid = (start + end) //2
        
    for c in cm :
        count += (c//mid)

    if count >= N :
        return max(func(mid + 1, end), mid)

    else :
        return func(start, mid-1)

print(func(1, stand))


    
"""
for s in range(stand, 0, -1) :
    count = 0
    for c in cm :
        count += int(c/s)
        
    if count >= N :
            print(s)
            exit(0)
"""