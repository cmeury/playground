def collatz(start):
    """ n -> n/2 (n is even),n -> 3n + 1 (n is odd)"""
    counter = 1
    n = start
    while n != 2:
        if n % 2 == 0:
            n /= 2
        else:
            n = (n * 3) + 1
        counter += 1

    counter += 1
    return counter

chain_lengths = []
for i in range(2,1000000):                                # will be from 2 to 999'999
    chain_lengths.append(collatz(i))

print chain_lengths.index(max(chain_lengths)) + 2   # because we started from 2 and not from 0