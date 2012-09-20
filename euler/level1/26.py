import sys
import math

def check_recurring(decimals):
    for i in range(0, len(decimals)):
        find = decimals[i+1:].find(decimals[i])
#        print decimals[i+1:]
#        print decimals[i]
        if find > -1:
            # add back the shifting we did before finding
            find += i+1
            if find == i + 1:
                return decimals[i]
            else:
                idx = 1
                recurring = True
                for j in range(i+1,find):
                    if find + idx > len(decimals)-1:
                        return ""
                    if decimals[find + idx] != decimals[j]:
                        recurring = False
                        break
                    idx += 1
                if recurring == True:
                    return decimals[i:find]
    # no recurring found
    return ""

#check_recurring("1428571")
#sys.exit()
def divide_one_by(divisor):
    if divisor < 2:
        raise ValueError("divisor must be greater than 1")
    dividend = 1
    decimals = ""

    if dividend < divisor:
        dividend *= 10

    while True:
        while dividend < divisor:
            dividend *= 10
        num = math.floor(dividend / divisor)
        decimals += str(int(num))
        dividend = dividend % divisor
        if dividend == 0:
            break
        recurring = check_recurring(decimals)
        if len(recurring) > 0:
            return recurring
    return ""

max_length = 0
max_length_divisor = 1
for i in range(2,1000):
    recurring = divide_one_by(i)
    if len(recurring) > 0:
        if len(recurring) > max_length:
            max_length = len(recurring)
            max_length_divisor = i

print max_length
print max_length_divisor


