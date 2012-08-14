#The prime factors of 13195 are 5, 7, 13 and 29.
#What is the largest prime factor of the number 600851475143 ?

def is_Prime(n):
	if n == 0:
		return False
	if n == 1:
		return True
	if n == 2:
		return False
	for i in range(2,n,1):
		if n % i == 0:
			return False
	return True

input = 600851475143 

for i in range(input,3,-1):
	if input % i == 0:
		if is_Prime(i):
			foundPrime = True
			largestPrime = i
			break

if foundPrime:
	print "Found largest prime factor for " + str(input)  + ": " + str(largestPrime)
else:
	print "Did not find any largest prime factor for " + str(input)

