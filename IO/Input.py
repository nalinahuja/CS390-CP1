'''

#Problem

You will be given two numbers through standard input, and you will need to print out the sum of the two numbers.

#Input Format

Input contains one line with two integer numbers, x and y. There will be a space between the two integers.

#Constraints

x < 1000000

y < 1000000

#Output Format

An integer indicate the sum.

'''

import random
import sys
import os

dataIn = raw_input().split(" ")
print(int(dataIn[0]) + int(dataIn[1]))
