import math

def sum_of_proper_divisors(x):
    divs = []
    for i in xrange(0,x+1,1):
        if x % i == 0:
            divs.append(i)
    return sum(divs)

print sum_of_proper_divisors(220)
print sum_of_proper_divisors(sum_of_proper_divisors(220))

amicable_nums = []
for i in range(1,10000):
    if i in amicable_nums:
        continue
    current_sum = sum_of_proper_divisors(i)
    viceversa = sum_of_proper_divisors(current_sum)
    if i == viceversa:
        amicable_nums.append(i)
        amicable_nums.append(current_sum)

print amicable_nums
print sum(amicable_nums)

unique_nums = set()
for i in amicable_nums:
    unique_nums.add(i)

print sum(unique_nums)
# 80568 incorrect
# 40284 incorrect
# 48942 incorrect
# 23934 incorrect
