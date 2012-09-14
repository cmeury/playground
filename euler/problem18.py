# .. Find the maximum total from top to bottom of the triangle ..
import networkx


class TriangleRoutes:

    def __init__(self, filename):
        self.triangle = self.read_triangle(filename)

    def max_path(self):
        print "generating graph.."
        graph = self.build_graph()
        print "generating all simple paths.."
        path_list = self.build_paths(graph)
        sums = []
        print "calculating sums.."
        for path in path_list:
            current_sum = 0
            for node in path:
                (x, y) = map(int, node.split(':'))
                current_sum += self.triangle[y][x]
            sums.append(current_sum)
        print "determining max sum.."
        return max(sums)

    def build_paths(self, g):
        last_line = self.triangle[len(self.triangle)-1]
        path_list = []
        for i in range(0,len(last_line)):
            path_list.extend(list(networkx.all_simple_paths(g, self.hashify(0,0), self.hashify(i, len(self.triangle)-1))))

        return path_list

    def build_graph(self):
        """n: grid size"""
        g = networkx.DiGraph()
        triangle = self.triangle

        # build nodes
        for y in range(0,len(triangle)):
            line = triangle[y]
            for x in range(0,len(line)):
                g.add_node(self.hashify(x,y), value=triangle[y][x])

        # connect nodes
        for y in range(0,len(triangle)):
            line = triangle[y]
            if not y == len(triangle)-1:
                for x in range(0,len(line)):
                    g.add_edge(self.hashify(x,y), self.hashify(x,y+1))
                    g.add_edge(self.hashify(x,y), self.hashify(x+1,y+1))
        return g

    def hashify(self, x, y):
        return str(x) + ':' + str(y)

    def read_triangle(self, filename):
        f = open(filename, 'r')
        triangle = []
        for line in f:
            triangle.append(map(int, line.split(' ')))
        return triangle


if __name__ == '__main__':
    triangleroutes = TriangleRoutes("problem18_small.txt")
    print triangleroutes.max_path()



