p, m = map(int, input().split())

result = []

for _ in range(p) :
    l, n = input().split()
    l = int(l)
    tf = True

    if len(result) == 0 :
        result.append({n:l})

    else :
        for i in range(len(result)) :
            if len(result[i]) < m :
                lv = list(result[i].values())[0]
                if lv + 10 >= l and lv - 10 <= l :
                    result[i][n] = l
                    tf = False
                    break
        if tf :
            result.append({n:l})

for r in result :
    r = sorted(r.items())
    print("Started!" if len(r)==m else "Waiting!")
    for k, v in r :
        print(v, k)