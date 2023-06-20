from collections import deque

card = deque(range(1, int(input())+1))
count = 0

while len(card) > 1 :
    card.popleft()
    card.append(card.popleft())

print(card[0])