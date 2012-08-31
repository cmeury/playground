import math

def triplet(max):
    c = 2
    while not c >= max:
        for a in range(1, c):
            for b in range(a, c):
                if math.pow(a, 2) + math.pow(b, 2) == math.pow(c, 2) and ( a + b + c ) == 1000:
                    return a, b, c
        c += 1
    return -1

results = triplet(math.pow(10,50))
print results[0] * results[1] * results[2]