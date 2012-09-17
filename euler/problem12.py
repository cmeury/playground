import sys

# from problem 7
def prime_factors(n):
    if n == 2:
        return [2]
    factors = []
    i = 2
    while i < n/2 + 1:
        if n % i == 0:
            div = n / i
            factors.append(i)
            factors.extend(prime_factors(div))
            break
        i += 1
    if len(factors) == 0:
        factors.append(n)
    return factors

def triangle(x):
    return (x * (x + 1)) / 2

def factors(x):
    pf = prime_factors(x)
    factor_counts = []
    added = []
    for f in pf:
        if not f in added:
            count = pf.count(f)
            factor_counts.append([f,count])
            added.append(f)

    product = 1
    for fc in factor_counts:
        product *= (fc[1] + 1)
    return product

i = 0
while True:
    i += 1
    t = triangle(i)
    if factors(t) > 500:
        print t
        break