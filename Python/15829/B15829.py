r = 31
M = 1234567891

l = int (input())
str = input()

result = 0
for i in range(0, l) :
    result += pow(r, i) * (ord(str[i]) - 96)

print(result % M)