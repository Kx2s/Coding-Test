import sys
def input() : return sys.stdin.readline()

def start (arr) :
    stack = []
    for a in arr :
        if a == "(" :
            stack.append(1)
        elif a == ")" :
            if len(stack) == 0 :
                print("NO")
                return
            else :
                stack.pop()
    print("YES" if len(stack) == 0 else "NO")


for _ in range(int(input())) :
    start(input())