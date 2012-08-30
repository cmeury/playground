# Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
# How many routes are there through a 20x20 grid?
import networkx
from networkx.classes.graph import Graph

class GridRoutes:

    def __init__(self, n):
        self.grid = self.buildGrid(n)
        self.counter = 0

    def routes(self):
        tree = networkx.bfs_tree()
        return 0

    def buildGrid(self, n):
        """n: grid size"""
        g = networkx.Graph()

        # build nodes
        for y in range(0,n,):
            for x in range(0,n):
                g.add_node(self.hashify(x,y), visited=False)
        # connect all the nodes
        for y in range(0,n,):
            for x in range(0,n):
                if not x == n-1:
                    g.add_edge(self.hashify(x,y), self.hashify(x+1,y))
                if not y == n-1:
                    g.add_edge(self.hashify(x,y), self.hashify(x,y+1))
        return g

    def hashify(self, x, y):
        return str(x) + ':' + str(y)

if __name__ == '__main__':
    gr = GridRoutes()
    gr.buildGrid(3)
    print gr.g.number_of_edges()
