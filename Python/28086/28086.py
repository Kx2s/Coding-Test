import sys, math

str = sys.stdin.readline().strip()
AB = []
sign = ""
m = 0
for i in ["*", "/", "+", "-"] :
    AB = str.split(i)

    if (len(AB) != 1):
        sign = i
        if (len(AB) > 2):
            m = len(AB) - 1
            del(AB[0])
        break

for i in [0, 1] :
    if "-" in AB[i] :
        m += 1
        AB[i] = AB[i].strip("-")
    AB[i] = int(AB[i], 8)


sol = 0
if sign == "+":
    if (m == 1) :
        sol = 0 - AB[0] + AB[1]
    else :
        sol = AB[0] + AB[1]
    m = 0

if sign == "-":
    if (m > 1) :
        sol = 0 - AB[0] - AB[1]
    else :
        sol = AB[0] - AB[1]
    m = 0

if sign == "*":
    sol = AB[0] * AB[1]

try:
    if sign == "/":
        if (m%2 == 0):
            sol = math.floor(AB[0] / AB[1])
        else :
            sol = math.ceil(AB[0] / AB[1])
except:
    print("invalid")
    quit(0)

sol = format(sol, "o")

if m%2 != 0  and sol != "0" and sol != 0:
    sol = "-" + format(sol)

print(sol)