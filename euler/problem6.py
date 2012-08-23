#The sum of the squares of the first ten natural numbers is,
#12 + 22 + ... + 102 = 385
#The square of the sum of the first ten natural numbers is,
#(1 + 2 + ... + 10)2 = 552 = 3025
#Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
#Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
import sys
import math

def diff(n):
	max = int(n)
	if max < 1:
		raise ValueError("argument needs to be at least: 1")
	sum_squares = 0
	sum_values = 0
	for i in range(1,max+1,1):
		sum_values += i
		sum_squares += math.pow(i,2)
	squared_values = math.pow(sum_values,2)
	difference = squared_values - sum_squares
	print "sum of squares = " + str(sum_squares)
	print "(sum of values)^2 = " + str(squared_values)
	print "difference = " + str(difference)



if len(sys.argv) < 2:
	print "please supply an argument"
	sys.exit()
argument = sys.argv[1]

diff(argument)
