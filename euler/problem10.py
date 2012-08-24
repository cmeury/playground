#The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
#Find the sum of all the primes below two million.

import sys
import math

def find_prime(n):
	idx = int(n)
	if idx < 1:
		raise ValueError("argument needs to be at least: 1")
	if idx == 1:
		return 2

	primes = []
	i = 2
	while i < idx:
		print str(i) + " - " + str(len(primes))		
		if str(i)[-1:] in (0,2,4,6,8):
			i += 1
			continue
		if(check_prime(i)):
			primes.append(i)
		i += 1
	print primes
	sum = 0
	for j in primes:
		sum += j
	return sum

def check_prime(x):
	for i in range(2,x,1):
		if x % i == 0:
			return False
	return True

def mod(n):
	if n == 2:
		return [2]
	factors = []
	i = 2
	while i < n/2 + 1:
		if n % i == 0:
			div = n / i
			factors.append(i)
			factors.extend(mod(div))
			break	
		i += 1
	if len(factors) == 0:
		factors.append(n)
	return factors



if len(sys.argv) < 2:
	print "please supply an argument"
	sys.exit()

argument = sys.argv[1]
print find_prime(argument) 