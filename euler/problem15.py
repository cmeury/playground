# Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
# How many routes are there through a 20x20 grid?
import networkx
from networkx.classes.graph import Graph

class GridRoutes:

    def __init__(self, n):
        self.size = n
        self.grid = self.buildGrid()
        self.counter = 0

    def routes(self):
        paths = networkx.all_simple_paths(self.grid, self.hashify(0,0), self.hashify(self.size-1,self.size-1))
#        print list(paths)
        return len(list(paths))

    def buildGrid(self):
        """n: grid size"""
        g = networkx.Graph()

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
    gr = GridRoutes(3)
    print gr.routes()