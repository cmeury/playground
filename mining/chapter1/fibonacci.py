__author__ = 'Ced'

last = 1
current = 2
sum = 2
while current < 4000000:
    new = last + current
    last = current
    current = new
    if new % 2 == 0:
        sum += current
print sum