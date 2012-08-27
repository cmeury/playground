import math
f = open('problem13.txt', 'r')
digits = []
for line in f:
    digits.append(int(line))
sum = math.fsum(digits)
print str(sum)[0] + str(sum)[2:11]
