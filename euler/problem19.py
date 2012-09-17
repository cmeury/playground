# How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

def days_of_month(month, year):
    if month in (9,4,6,11):
        return 30
    if month in (1,3,5,7,8,10,12):
        return 31
    if month == 2:
        if leap(year):
            return 29
        else:
            return 28

def leap(year):
    if year % 4 == 0:
        if year % 100 == 0:
            if year % 400 == 0:
                return True
            else:
                return False
        else:
            return True

    else:
        return False

rest = 1 # because 1900-1-1 is a monday
sundays_on_first = 0
for y in range(1900,2000+1):
    for m in range(1,12+1):
        if rest == 0:
            if y != 1900:
                sundays_on_first += 1
        days = days_of_month(m, y)
        rest = (days + rest) % 7

print sundays_on_first

# 77 is wrong
# 174 is wrong (with 1901, verified with Excel)
# 172 is wrong (without 1900)
# 171 is correct (we are one off at the beginning, rest=1)