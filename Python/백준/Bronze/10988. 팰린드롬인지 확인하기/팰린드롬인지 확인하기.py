S = input()

sl = []
sr = []

for s in S:
    sl.append(s)

sr = sl.copy()
sr.reverse()

if sr == sl :
    print(1)
else :
    print(0)