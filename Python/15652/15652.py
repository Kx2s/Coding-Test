N, M = map(int, input().split())
result = []

for _ in range(M) :
    result.append(0)

def p() :
    for i in result :
        print(i, end=" ")
    print()

def dfs(num, count):
    if count == M :
        p()
        return
    
    for i in range(num, N+1) :
        result[count] = i
        dfs(i, count + 1)

dfs(1, 0)