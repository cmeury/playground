import math

def sum_of_proper_divisors(x):
    half = math.trunc(x / 2)
    divs = []
    for i in xrange(half,0,-1):
        if x % i == 0:
            divs.append(i)
    return sum(divs)

amicable_nums = set()
for i in range(0,10000):
    if i in amicable_nums:
        continue
    current_sum = sum_of_proper_divisors(i)
    viceversa = sum_of_proper_divisors(current_sum)
    if i == viceversa:
        amicable_nums.add(i)
        amicable_nums.add(current_sum)

print amicable_nums
print sum(amicable_nums)

# 80568 incorrect
# 40284 incorrect
# 48942 incorrect
# 23934 incorrect
