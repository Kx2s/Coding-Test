import sys
input = sys.stdin.readline
N, M = map(int, input().split())

titles = []
powers = []

for _ in range(N) :
    name, power = input().split()
    titles.append(name)
    powers.append(int(power))

for _ in range(M) :
    start = 0
    end = N-1
    cur = (start+end)//2
    power = int(input())

    while start != end :
        if power <= powers[cur] :
            end = cur
        elif powers[cur] < power:
            start = cur+1
        cur = (start+end)//2
    print(titles[cur])