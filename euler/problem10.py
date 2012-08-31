#The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
#Find the sum of all the primes below two million.
from array import array
import math

def find_sum_of_primes_below(size):
    """
    Sieve of Eratosthenes
    """
    if size < 1:
        raise ValueError("argument needs to be at least: 1")
    if size == 1:
        return [2]

    numbers = array('c','1' * (size+1))

    p = 2
#    primes = []
    sum = 0
    while True:
        sum += p
        print p
        for i in range(p+p, size, p):
            numbers[i] = '0'

        found = False
        for i in range(p+1, size):
            if numbers[i] == '1':
                p = i
                found = True
                break
        if not found:
            break

    return sum

if __name__ == '__main__':
    print find_sum_of_primes_below(2000000)
#    print sum(find_primes_below(2000000))
