permutations = []

def perms(permutations, digits):
    if len(digits) == 1:
        print permutations.extend(digits)
        return
    for digit in digits:
        new_digits = digits[:]
        new_digits.remove(digit)
        permutations.append(digit)
        perms(permutations[:], new_digits)
    return


perms(permutations, range(3))
print permutations