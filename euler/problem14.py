list = []

def collatz(start):
    """ n -> n/2 (n is even),n -> 3n + 1 (n is odd)"""

    # anchoring
    if start == 2:
        list.append(2)
        return 1

    # even
    if start % 2 == 0:
        new_start = start / 2
    else:
        new_start = (start * 3) + 1

    list.append(new_start)
    return collatz(new_start)

collatz(13)
print list