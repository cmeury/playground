# Work out the first ten digits of the sum of the one-hundred 50-digit numbers in problem13.txt.
import math
f = open('problem13.txt', 'r')
digits = []
for line in f:
    digits.append(int(line))
sum = math.fsum(digits)
print str(sum)[0] + str(sum)[2:11]
