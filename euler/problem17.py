import math
import re

class Wordify:

    def __init__(self):
        self.singles = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
        self.teens = ['eleven', 'twelve', 'thirteen', 'fourteen','fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']
        self.tens = ['', 'twenty', 'thirty', 'fourty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
        self.hundreds = ['']

    def transform(self, number):
        if number == 0:
            return ''
        elif number < 10:
            return self.singles[number-1]
        elif number < 20:
            return self.teens[number-1]
        elif number < 100:
            ten = math.trunc(number / 10)
            single = number - (ten * 10)
            return self.tens[ten-1] + '-' + self.transform(single)
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
        string = self.transform(number)
        alpha = re.compile(r"[a-zA-Z]")
        for c in string:
            if alpha.§
