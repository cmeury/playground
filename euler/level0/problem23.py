import math

def sum_of_proper_divisors(x):
    half = math.trunc(x / 2)
    divs = []
    for i in xrange(half,0,-1):
        if x % i == 0:
            divs.append(i)
    return sum(divs)

def is_abundant(x):
    return sum_of_proper_divisors(x) > x

def abundant_numbers_under(x):
    abundant_numbers = []
    for i in xrange(1,x+1,1):
        if is_abundant(i):
            abundant_numbers.append(i)
    return abundant_numbers

def sums_of_two_abundant_numbers(abundant_numbers, limit):
    sums = set()
    for i in abundant_numbers:
        for j in abundant_numbers:
            current_sum = i + j
            if (current_sum > 0) & (current_sum <= limit):
                sums.add(current_sum)
    return sums

limit = 28123

abundant_numbers = abundant_numbers_under(limit)
sums = sums_of_two_abundant_numbers(abundant_numbers, limit)

numbers = range(1,limit+1)
for i in sums:
    numbers.remove(i)

print sum(numbers)
