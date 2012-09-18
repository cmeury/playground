# In the 20x20 grid in the file problem11.txt, four numbers along a diagonal line have been marked in red.
# What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 2020 grid?

def read_file(filename):
    f = open(filename, 'r')
    grid = []
    for line in f:
        grid.append(map(int, line.split(' ')))
    return grid

grid = read_file('problem11.txt')

minimum=0
maximum=20
step=4
max_product=0

for y in range(minimum, maximum):
    for x in range(minimum, maximum):
        if x < maximum-step+1:
            hori = grid[y][x] * grid[y][x+1] * grid[y][x+2] * grid[y][x+3]
            if y < maximum-step+1:
                diago1 = grid[y][x] * grid[y+1][x+1] * grid[y+2][x+2] * grid[y+3][x+3]
                diago2 = grid[y+3][x] * grid[y+2][x+1] * grid[y+1][x+2] * grid[y][x+3]
        if y < maximum-step+1:
            verti = grid[y][x] * grid[y+1][x] * grid[y+2][x] * grid[y+3][x]

        local_max_product = max(hori,verti,diago1,diago2)
        if local_max_product > max_product:
            max_product = local_max_product

print max_product