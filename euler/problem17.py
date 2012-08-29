import math
import re
import string

class Wordify:

    def __init__(self):
        self.singles = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
        self.teens = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen','fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']
        self.tens = ['', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']

    def transform(self, number):
        if number == 0:
            return ''
        elif number < 10:
            return self.singles[number-1]
        elif number < 20:
            return self.teens[number-10]
        elif number < 100:
            ten = math.trunc(number / 10)
            single = number - (ten * 10)
            if single > 0:
                return self.tens[ten-1] + '-' + self.transform(single)
            else:
                return self.tens[ten-1]
        elif number <  1000:
            hundred = math.trunc(number / 100)
            rest = number - (hundred * 100)
            final_string = self.transform(hundred) + ' hundred'
            if rest > 0:
                final_string += ' and ' + self.transform(rest)
            return final_string
        elif number == 1000:
            return "one thousand"
        else:
            raise NotImplementedError


    def count_letters(self, number):
        words = self.transform(number)
        i = 0
        for c in words:
            if c in string.letters:
                i += 1
        return i

if __name__ == "__main__":
    w = Wordify()
    count = 0
    for n in range(1,1001):
        count += w.count_letters(n)
    print count