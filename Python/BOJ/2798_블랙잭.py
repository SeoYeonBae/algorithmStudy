# CLASS_2 2798 블랙잭
from itertools import combinations

N, M = map(int, input().split())

cards = list(map(int, input().split()))

maxResult = 0

for card in combinations(cards, 3):
    if maxResult < sum(card) <= M:
        maxResult = sum(card)

print(maxResult)