S = input()

li = [0] * 26

for s in S :
    li[ord(s) - 97] += 1

for l in li :
    print(l, end=" ")