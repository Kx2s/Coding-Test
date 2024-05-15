import sys
input = sys.stdin.readline
N = int(input())

mx = 0
cnt = 0
result = 0
price = [0] * 100000

for i in range(N) :
    tmp = int(input())
    price[tmp] += 1
    result += tmp
    if mx < tmp :
        mx = tmp

for i in range(mx, 0, -1) :
    cnt += price[i]

    if cnt >= 3 :
        result -= i * (cnt//3)
        cnt %= 3
        
print(result)