
def collatz(start):
    """ n -> n/2 (n is even),n -> 3n + 1 (n is odd)"""
    counter = 0
#    list = [start]
    n = start
    while n != 2:
        if n % 2 == 0:
            n /= 2
        else:
            n = (n * 3) + 1
#        list.append(n)
        counter += 1

#    list.append(1)
    counter += 1
    return counter


maximum = 1000000
chain_lengths = []
for i in range(2,maximum):
    if i % 1000 == 0:
        print i
    chain_lengths.append(collatz(i))

print max(chain_lengths)
