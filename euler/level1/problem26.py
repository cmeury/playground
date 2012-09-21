import math

class Recurring:
    def check_recurring(self, decimals):
        for i in range(0, len(decimals)):
            find = decimals[i+1:].find(decimals[i])
            shift = i + 1
            while find > -1:
                find += shift
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
                # next find?
                find = decimals[find+1:].find(decimals[i])
                shift += find+1

        # no recurring found
        return ""
                                          #                        #

    def divide_one_by(self, divisor):
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
            recurring = self.check_recurring(decimals)
            if len(recurring) > 0:
                return recurring
            # stop at one point, might be irrational
            if len(decimals) > 2000:
                return ""

        return ""

if __name__ == '__main__':
    rec = Recurring()
    max_length = 0
    max_length_divisor = 1
    for i in range(2,1000):
        recurring = rec.divide_one_by(i)
        if len(recurring) > 0:
            if len(recurring) > max_length:
                max_length = len(recurring)
                max_length_divisor = i

    print max_length
    print max_length_divisor



# incorrect : 214 (limit 50)
# incorrect : 529 (limit 1000)
# incorrect : 499 (limit 2000)