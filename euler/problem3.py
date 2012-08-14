#The prime factors of 13195 are 5, 7, 13 and 29.
#What is the largest prime factor of the number 600851475143 ?
import math

input = 600851475143 

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

print mod(input)	

