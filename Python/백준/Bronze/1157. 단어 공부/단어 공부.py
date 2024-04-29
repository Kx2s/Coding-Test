S = input()

cnt = [0] * 26
for s in S.lower() :
    cnt[ord(s) - 97] += 1
    
if cnt.count(max(cnt)) > 1:
    print("?")
else :
    print(chr(cnt.index(max(cnt)) + 65))