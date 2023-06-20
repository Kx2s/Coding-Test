import sys

N, M = map(int, sys.stdin.readline().split())

one = []
two = []

for _ in range(N) :
    one.append(sys.stdin.readline().replace("\n", ""))

for _ in range(M) :
    two.append(sys.stdin.readline().replace("\n", ""))

MAX = len(max(max(one), max(two)))

count = 0
for i in one :
    for j in range(len(i) + 1):
        if i[0:j] in two :
            del(two[two.index(i[0:j])])
            count += 1
print(count)