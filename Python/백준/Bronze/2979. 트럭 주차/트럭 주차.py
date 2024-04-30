pay = list(map(int, input().split()))

parking = [0] * 100

for _ in range(3) :
    i, o = map(int, input().split())
    for j in range(i, o) :
        parking[j] += 1

sum = 0
for i in range(1, 4) :
    sum += parking.count(i) * pay[i-1] * i

print(sum)