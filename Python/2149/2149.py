key = input()
encord = input()
count = int(len(encord)//len(key))
print(count)

key_s = sorted(key)
decord = []
result = []
for i in range(len(key)) :
    decord.append(key_s[i] + encord[count*i : count*(i+1)])

for i in range(0, len(key)) :
    for j in range(0, len(key)) :
        if key[i] == decord[j][0] :
            result.append(decord.pop(j))
            break

for i in range(count) :
    for j in range(len(key)) :
        print(result[j][i+1], end="")


"""
D EIAAHEBX
G OIFWEHRX
H ONNAALRS
I UMNREDEX
M CTLFTVEX
N PEDARTAX
U NAARYIEX

ONCEUPONATIMEINALANDFARFARAWAYTHERELIVEDTHREEBEAR
ONCEUPONATIMEINALANDFARFARAWAYTHERELIVEDTHREEBEARSXXXXXX
"""