# Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
# How many routes are there through a 20x20 grid?
from time import time

import networkx

class GridRoutes:

    def __init__(self, n):
        if n < 1:
            raise ValueError
        self.size = n
        self.grid = self.buildGrid()
        self.counter = 0

    def routes_long(self):
        paths = networkx.all_simple_paths(self.grid, self.hashify(0,0), self.hashify(self.size-1,self.size-1))
        return len(list(paths))

    def routes(self):
        print "generating simple paths.."
        paths = networkx.all_simple_paths(self.grid, self.hashify(0,0), self.hashify(self.size-1,self.size-1))

        print "listing paths.."
        count = 0
        for p in paths:
            count += 1
            if count % 100000 == 0:
                print count
        return count

    def buildGrid(self):
        """n: grid size"""
        g = networkx.DiGraph()

        # build nodes
        for y in range(0,self.size):
            for x in range(0,self.size):
                g.add_node(self.hashify(x,y), visited=False)
        # connect all the nodes
        for y in range(0,self.size):
            for x in range(0,self.size):
                if not x == self.size-1:
                    g.add_edge(self.hashify(x,y), self.hashify(x+1,y))
                if not y == self.size-1:
                    g.add_edge(self.hashify(x,y), self.hashify(x,y+1))
        return g

    def hashify(self, x, y):
        return str(x) + ':' + str(y)

if __name__ == '__main__':
#    for i in range(1,15):
#        before = time()
#        gr = GridRoutes(i)
#        after = time()
#        print str(i) + 'x' + str(i) + ' -> ' + str(gr.routes()) + ', in ' + str(after-before) + ' seconds'
    print GridRoutes(4).routes()