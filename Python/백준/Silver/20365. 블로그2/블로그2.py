import sys
input = sys.stdin.readline

N = int(input())
arr = []
for i in input() :
    if not arr or arr[-1] != i :
        arr += i
result = 0
R = arr.count("R")
B = arr.count("B")

if R > B : 
    print(B+1)
else :
    print(R+1)