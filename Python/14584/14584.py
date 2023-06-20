str = input()
N = int(input())
word = []

for i in range(0, N) :
    word.append(input())

count = 0
end = True

while (end) :
    result = ""
    for i in str:
        result += chr((ord(i) - 97 + count) % 26 + 97)

    count += 1
    for s in word :
        if s in result :
            end = False

print(result)