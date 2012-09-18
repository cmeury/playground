import string

def read_file(filename):
    f = open(filename, 'r')
    names = []
    for line in f:
        names.extend([name.replace('"','') for name in line.split(',')])
    return names

def alpha_value(name):
    return sum([string.ascii_uppercase.find(char)+1 for char in name])

sorted_names = sorted(read_file("problem22.txt"))

scored_names = []
for i in range(len(sorted_names)):
    scored_names.append(alpha_value(sorted_names[i] * (i+1)))

print sum(scored_names)