#A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91x99.
#Find the largest palindrome made from the product of two 3-digit numbers.


def find():
	for i in range(998001,10000,-1):
		for j in range(100,999,1):
			if i % j == 0:
				div = i / j
				if len(str(div)) == 3:
					if str(i)[:3] == str(i)[-3:][::-1]:
						print str(j) + "x" + str(div) + "=" + str(i)
						return 

find()
