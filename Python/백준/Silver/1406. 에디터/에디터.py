import sys
def input() :
    return sys.stdin.readline().rstrip()

left = list(input())
right = []

for _ in range(int(input())) :
    ctrol = input()
    if ctrol[0] == "L" and left:
        right.append(left.pop())
    elif ctrol[0] == "D" and right:
        left.append(right.pop())
    elif ctrol[0] == "B" and left:
        left.pop()
    elif ctrol[0] == "P" :
        left.append(ctrol[-1])

print("".join(left+right[::-1]))