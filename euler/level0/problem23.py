from string import digits

print digits

def lexicograpic_order(elements):
    print elements
    if len(elements) < 2:
        return [elements[0]]

    return exicograpic_order(elements[1:])



elements = [ele for ele in '012']

perms = []
for a in elements:
    new = elements[1:]

    if new.count(a) > 0:
        new = new.remove(a)
    for b in new:
        new = new[1:]
        if new.count(b) > 0:
            new = new.remove(b)
        for c in new:
            perms.append(a + b + c)

print perms