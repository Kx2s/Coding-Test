inp = input()

def start(v, s, e) :
    v += 13

    if v > e :
        v %= e
        v += s - 1

    return v

result = []

for s in inp :
    asc = ord(s)
    if asc < 91 and asc >= 65 :
        result.append(start(asc, 65, 90))

    elif asc >= 97 and asc < 123 :
        result.append(start(asc, 97, 122))

    else :
        result.append(asc)

for r in result :
    print(chr(r), end="")