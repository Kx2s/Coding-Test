import sys
def input() : return sys.stdin.readline().rstrip()

def cal (i) :
    global f, e

    f += i
    e += i

N, M = map(int, input().split())

f = 1
e = f + M - 1
result = 0

for _ in range(int(input())) :
    num = int(input())

    if num > e :
        result += num-e
        cal(num-e)
    elif num < f :
        result -= num-f
        cal(num - f)
print(result)