# Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
# How many routes are there through a 20x20 grid?

def pairwise_add(row):
    new_row = []
    for i in range(0, len(row)-1):
        new_row.append(row[i] + row[i+1])
    return new_row

def routes(size):
    row = [1,1]
    while len(row) < size+1:
        row = [1] + pairwise_add(row) + [1]
    while len(row) > 1:
        row = pairwise_add(row)
    return row[0]

if __name__ == '__main__':
    print routes(20)