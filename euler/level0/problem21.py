import math

def sum_of_proper_divisors(x):
    half = math.trunc(x / 2)
    divs = []
    for i in xrange(1,half+1,1):
        if x % i == 0:
            divs.append(i)
    return sum(divs)


amicable_nums = set()
for i in range(1,10000):
    if i in amicable_nums:
        continue
    current_sum = sum_of_proper_divisors(i)

    # no amicable pair if e.g. sum(6) = 6
    if i != current_sum:
        viceversa = sum_of_proper_divisors(current_sum)
        if i == viceversa:
            amicable_nums.add(i)
            amicable_nums.add(current_sum)

print sum(amicable_nums)
