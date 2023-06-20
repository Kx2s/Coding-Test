import sys

N = int(sys.stdin.readline())
l = []

for _ in range(N):
    l.append(int(sys.stdin.readline()))

l.sort(reverse=True)

for i in range(N-2) :
    if l[i] < l[i+1] + l[i+2] :
        print(l[i] + l[i+1] + l[i+2])
        quit()
print(-1)

"""
N개중 3개의 빨대
그럼 3개를 중복없이 뽑아야되고


반복(재귀(반복(재귀(반복(재귀(리턴))))))
비교는 처음에서만 해야됨

하나 선택 -> 하나 선택 -> 나머지중 하나
        -> 나머지중 하나
나머지중 하나

한것의 최댓값


"""