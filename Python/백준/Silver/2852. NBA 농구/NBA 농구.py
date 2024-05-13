import sys
def input() : return sys.stdin.readline().rstrip()

time = 0
goal = []
result = [0, 0]

for _ in range(int(input())) :
    team, sec = input().split()
    sec = list(map(int, sec.split(":")))
    sec = sec[0]*60 + sec[1]
    team = int(team)

    if goal :
        if goal[0] == team :
            goal.append(team)
        
        else :
            goal.pop()
            if len(goal) == 0 or team == 0:
                result[team-2] += sec - time
                time = sec

    else :
        goal.append(team)
        time = sec

if goal :
    result[goal[0]-1] += 48*60 - time


for i in range(2) :
    min = '{0:02d}'.format(result[i]//60)
    sec = '{0:02d}'.format(result[i]%60)
    print(f'{min}:{sec}')