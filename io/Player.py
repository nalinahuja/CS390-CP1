'''

#Problem

In the Tetris World Championship, the judges decided that there should be a random prize within the top 100 participants to encourage more people to participate.
The random number K is decided by the judges, and the prize is awarded to the Kth best player in the leaderboard.

Given K, the number of players, and their scores in random order - find out the score of the player who won the prize!

#Input Format

The first line has two integers N for number of players(and hence their scores) and K.

Following are N lines with the scores of the players.

#Constraints

0 < N <= 2000000

0 < K <= 100

#Output Format

Single integer with the score of the winning player.

'''

import random
import sys
import os

scores = []
initialization = raw_input().split(" ")

cnt = 0

while cnt < int(initialization[0]):
    scores.append(int(raw_input()))
    cnt = cnt + 1

scores.sort()
print(scores[len(scores) - int(initialization[1])])
