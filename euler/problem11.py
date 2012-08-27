# In the 20x20 grid in the file problem11.txt, four numbers along a diagonal line have been marked in red.
# What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 2020 grid?
import networkx as nx

def hashify(x, y):
    return str(x) + '-' + str(y) + ':' +  str(grid[y][x])

def read_file(filename):
    f = open(filename, 'r')
    grid = []
    for line in f:
        grid.append(map(int, line.split(' ')))
    return grid

grid = read_file('problem11.txt')

min=0
max=19

g = nx.Graph()

# constructing the graph from the grid
for x in range(min, max):
    for y in range(min, max):
        g.add_node(hashify(x,y), value = grid[y][x])
        if x != max: # horizontal
            g.add_edge(hashify(x,y), hashify(x+1,y))
        if y != max: # vertical
            g.add_edge(hashify(x,y), hashify(x,y+1))
            if x != 0: # diagonal right
                g.add_edge(hashify(x,y), hashify(x-1,y+1))
            if x != max: # diagonal left
                g.add_edge(hashify(x,y), hashify(x+1,y+1))

#for node in g.nodes_iter(data=True):
#    tree = nx.dfs_tree(g, node)

for a,b in g.nodes(data=True):
    print b['value']
    for c, d in nx.neighbors(g, a):
        print d['value']

