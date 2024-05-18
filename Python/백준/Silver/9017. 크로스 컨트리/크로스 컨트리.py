import sys
input = sys.stdin.readline

for T in range(int(input())) :
    N = int(input())
    arr = list(map(int, input().split()))
    
    dic = {}
    team = [0] * 201

    for i in range(len(arr)) :  #인원수 체크
        tmp = dic.get(arr[i], 0)
        dic[arr[i]] = tmp + 1
    dic = {k:[] for k,v in dic.items() if v == 6}    #6명 미만 제거

    score = 1
    for a in arr :      #점수 입력
        if dic.get(a) != None :
            dic[a].append(score)
            score += 1

    scores = [sum(v[:4]) for v in dic.values()] #4명까지 점수
    mn = min(scores)
    result = 0
    five = 1000
    for i in range(scores.count(mn)) :
        idx = scores.index(mn)
        scores[idx] = 0
        tmp = list(dic.values())[idx][4]
        if five > tmp :
            five = tmp
            result = list(dic.keys())[idx]

    print(result)