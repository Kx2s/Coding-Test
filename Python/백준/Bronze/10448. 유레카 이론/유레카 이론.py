def tri(n) :
    return int(n*(n+1)/2)

def search(a) :
    for i in range(1, a) :
        t = tri(i)
        if t >= a :
            return i-1
def start() :
    K = int(input())
    s = search(K)
    
    for i in range(s, 0, -1) :
        for j in range(i, 0, -1) :
            for k in range(j, 0, -1) :
                if tri(i) + tri(j) + tri(k) == K :
                    print(1)
                    return
                elif tri(i) + tri(j) + tri(k) < K :
                    break
    print(0)

for _ in range(int(input())) :
    start()