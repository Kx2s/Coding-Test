import sys
def input() : return sys.stdin.readline().rstrip()

li = input().split("-")
result = []

for l in li :
    sum = 0
    tmp = ""
    for i in range(len(l)) :        
        if l[i] == "+" :
            sum += int(tmp)
            tmp = ""
        else :
            tmp += l[i]
        if i == len(l)-1 :
            result.append(sum + int(tmp))
            break

sum = ""
for r in result :
    if sum == "" :
        sum = r
    else :
        sum -= r
print(sum)