#2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
#What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
import sys

def check_divisible(x,n):
	for i in range(2,x):
		if n % i != 0:
			return False
	return True

def smallest_prime_factor(n):
	i = 2
	while i < n/2 + 1:
		if n % i == 0:
			return i
		i += 1
	return n



def smallest_divisible(x):
	if x < 3:
		raise ValueError('must be greater than 2')
	product = 1
	factors = []
	for j in range(2,x+1):
		print "j: " +str(j)
		print "x: " +str(x)
		print "product: " + str(product)
		f = smallest_prime_factor(j)
		factors.append(f)
		product *= f
	div = product
	for i in factors:
		div /= i
		print "check " + str(i) + " --> " + str(div) + " is " + str(check_divisible(div,x))
	return product

maxVal = int(sys.argv[1])
div = smallest_divisible(maxVal)
print div

print "check: " + str(check_divisible(maxVal,div))
