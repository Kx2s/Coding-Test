while(True) :
    try :
        s, t = input().split()
        count = 0
        print(s, t)
        while(True) :
            if (s == t[0:count]) :
                print("Yes")
                break

            if (len(s) > len(t)) :
                print("No")
                break

            if (s[count] == t[count]) :
                count += 1
                continue
            t = t[0:count] + t[count+1 : len(t)]
    except :
        break