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

#1. Nimm die erste Zahl -> 0
#2. Entferne die gewählte Zahl aus der Liste -> [1,2]
#3. Nimm die erste Zahl -> 1
#4. Entferne die gewählte Zahl aus der Liste -> [2]
#5. Liste hat nur 1 Element
#6. Füge das ganze zur Liste hinzu (012)
#retourniere
#7. Nimm die zweite Zahl -> 2
#8. Entferne die gewählte Zahl aus der Liste -> [1]
#9. Liste hat nur 1 Element
#10. Füge das ganze zur Liste hinzu (021)
#retourniere
#11. Schleife fertig, retourniere
#
#perms(x)
#wenn die liste nur ein element hat:
#output liste
#retourniere
#iteriere über die liste x:
#neue_liste := Entferne die Zahl aus der Liste x
#perms(neue_liste)