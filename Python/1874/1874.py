import sys

n = int(sys.stdin.readline())

innum =[]
for _ in range(n) :
    innum.append(int(sys.stdin.readline()))

count = 0
num = 1
stack = []
result = []

while count < n :
    if num == innum[count] :
        result.append("+")
        result.append("-")
        num += 1
        count += 1

    elif num < innum[count] :
        result.append("+")
        stack.append(num)
        num += 1

    elif stack[-1] == innum[count] :
        stack.pop()
        result.append("-")
        count += 1
    
    else :
        print("NO")
        exit()
        

for i in result :
    print(i)
print("end")

"""
1 ~ n 개의 자연수 수열
현재 숫자보다 입력숫자가 더 크면 +
현재 숫자와 입력숫자가 같으면 + - 
현재 숫자가 입력숫자보다 크면 -
"""

