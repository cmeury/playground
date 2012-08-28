
def collatz(start):
    """ n -> n/2 (n is even),n -> 3n + 1 (n is odd)"""
    list = [start]
    n = start
    while n != 2:
        if n % 2 == 0:
            n /= 2
        else:
            n = (n * 3) + 1
        list.append(n)

    list.append(1)
    return list


chains = []
for i in range(2,100):
    chains.append(collatz(i))

max_length = 0
max_starting_point = 0
for chain in chains:
    if len(chain) > max_length:
        max_length = len(chain)
        max_starting_point = chain[0]

print max_length
print max_starting_point