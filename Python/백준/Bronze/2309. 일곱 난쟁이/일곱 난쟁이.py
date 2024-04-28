def start (li, con):

    for i in range(len(li)) :
        for j in range(i+1, len(li)) :
            if li[i] + li[j] == con:
                a= li[i]
                b = li[j]
                li.remove(a)
                li.remove(b)
                return li
    print("non")

cm = []



for _ in range(9) :
    cm.append(int(input()))

sum = sum(cm)

con = sum - 100

cm = start(cm, con)
cm.sort()
for c in cm :
    print(c)