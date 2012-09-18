import math

def sum_of_digits(x):
    number = math.trunc(math.pow(2,x))
    sum = 0
    for n in str(number):
        sum += int(n)
    return sum

print sum_of_digits(1000)