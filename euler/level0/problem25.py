f_1 = 1
f_2 = 1
counter = 2
while True:
    counter += 1
    n = f_1 + f_2
    if len(str(n)) >= 1000:
        print counter
        break
    f_1 = f_2
    f_2 = n