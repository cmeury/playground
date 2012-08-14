#The prime factors of 13195 are 5, 7, 13 and 29.
#What is the largest prime factor of the number 600851475143 ?

#for i in range(13195,1,-2):

def check(n):
	if n == 3:
		return 3
	for i in range(n-1,1,-1):
		if is_Prime(i):
			return check(i)

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




print check(10)

