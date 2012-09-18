#2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
#What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
import sys

def check_divisible(x,n):
	for i in range(2,x):
		if n % i != 0:
			return False
	return True

def small_div(x):
    number = x
    while True:
        number += 1
        divisible = True
        for i in range(1,x+1):
            if number % i != 0:
                divisible = False
                break
        if not divisible:
            continue
        else:
            break
    return number

maxVal = int(sys.argv[1])
div = small_div(maxVal)
print div
print "check: " + str(check_divisible(maxVal,div))
