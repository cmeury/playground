import copy

results = []

def perms(start, current):
    if len(start) == 1:
        new_result = copy.copy(current)
        new_result.append(copy.copy(start[0]))
        results.append(new_result)
        return
    for i in start:
        new_list = copy.copy(start)
        new_list.remove(i)
        new_current = copy.copy(current)
        new_current.append(i)
        perms(new_list, new_current)

perms(range(3), [])

print sorted(results)