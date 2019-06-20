'''

#Problem

Write a program that will determine if each color will be mostly read, green, or blue, based on its hexidecimal value. When reading a hex code from left to right,
the first two digits represent the red value, the next two represent the green value, and the last two represent the blue value.

Print out the color that has the highest value.

#Input Format

Each test file will have a number that states the number of colors you will receive, followed by the colors, with each on their own line.

#Constraints

To avoid having to determine if there are purple, browns, greys, black, and white, one color's value will always be greater than both of the others.

#Output Format

The possible colors are Red, Green, and Blue. Print each color on a new line.

'''

import random
import sys
import os

colors = []
dataPointCount = int(raw_input())

for i in range(0, dataPointCount):
    colors.append(raw_input())

for i in range(0, dataPointCount):
    hexColors = [colors[i][0:2], colors[i][2:4], colors[i][4:6]]
    colorValues = []

    for j in range(0, 3):
        colorValues.append(int(hexColors[j], 16))

    maximum = max(colorValues[0], max(colorValues[1], colorValues[2]))

    for j in range(0, 3):
        if colorValues[j] == maximum:
            if j == 0:
                colors[i] = ("Red")
            elif j == 1:
                colors[i] = ("Green")
            elif j == 2:
                colors[i] = ("Blue")

for i in colors:
    print(i)
