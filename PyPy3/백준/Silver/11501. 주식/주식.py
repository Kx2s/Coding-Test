import sys
def input() : return sys.stdin.readline().rstrip()

for _ in range(int(input())) :
    N = int(input())
    price = list(map(int, input().split()))

    result = 0
    m = 0
    while price :
        p = price.pop()
        
        if p >= m :
            m = p
        else :
            result += m-p

    print(result)