import math

def sum_of_digits(x):
    number = math.factorial(x)
    sum = 0
    for n in str(number):
        sum += int(n)
    return sum

print sum_of_digits(100)