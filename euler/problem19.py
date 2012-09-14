# How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

# Hints:
# 1 Jan 1900 was a Monday.
# Thirty days has September, April, June and November.
# All the rest have thirty-one,
# Saving February alone,
# Which has twenty-eight, rain or shine.
# And on leap years, twenty-nine.
# A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

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

def days_of_year(year):
    days = 0
    for i in range(12):
        days += days_of_month(i+1, year)
    return days

# 1 Jan 1901
# 31 Dec 2000
days = 0
for i in range(1901,2000+1,1):
    days += days_of_year(i)
print days / 7

# 1 Jan 1900 = monday
# want weekday?
# input year, month, day

def weekday(year, month, day):
    start = 1900
    days_of_year()
