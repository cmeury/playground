# http://projecteuler.net/problem=30

i = 1
total = 0
while True:
    i += 1
    cur_sum = 0
    for c in str(i):
        cur_sum += pow(int(c),5)
    if cur_sum == i:
        total += cur_sum
        print "new number: " + str(cur_sum) + " total: " + str(total)
