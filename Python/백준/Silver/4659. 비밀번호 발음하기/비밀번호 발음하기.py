import sys
input = sys.stdin.readline
mo = ['a','e','i','o','u']

while True :
    st = input().rstrip()
    if st == "end" :
        break


    M = 0
    Z = 0
    tmp = ""
    con = False
    stt = st.replace("ee", "e").replace("oo", "o")

    for s in stt :
        if s == tmp :
            con = False
            break

        if s in mo :
            con = True
            M += 1
            Z = 0
        else :
            Z += 1
            M = 0
        
        if M>2 or Z>2 :
            con = False
            break
        tmp = s
    print(f"<{st}> is", end=" ")
    print("acceptable." if con else "not acceptable.")