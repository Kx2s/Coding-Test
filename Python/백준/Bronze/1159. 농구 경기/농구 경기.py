player = [0] * 26
result = ""

for _ in range(int(input())) :
    player[ord(input()[0]) - 97] += 1

for i in range(len(player)) :
    if player[i] >= 5 :
        result += chr(i+97)

print(result if result != "" else "PREDAJA")