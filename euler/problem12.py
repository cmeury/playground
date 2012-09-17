def triangle(x):
    return sum(xrange(1,x+1))

def factors(x):
    factors = []
    for i in range(1,x+1):
        if x % i == 0:
            factors.append(i)
    return factors

for i in range(1,8):
    print str(triangle(i)) + " - " + str(factors(triangle(i)))