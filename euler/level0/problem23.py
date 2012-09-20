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

def calculate_abundant_numbers_under(x)
    abundant_numbers = []
    for i in xrange(1,x+1,1):
        if is_abundant(i):
            abundant_numbers.append(i)
    return abundant_numbers

abundant_numbers = calculate_abundant_numbers_under(28123)

#for i in xrange(1,28123+1,1):
    # some values here cannot be written as the sum of two abundant numbers, which ones?
