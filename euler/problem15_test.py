import unittest
from problem15 import GridRoutes

class GridRoutesTest(unittest.TestCase):

    def test_routes(self):
        gridroutes = GridRoutes(2)
        self.assertEqual(6, gridroutes.routes())

    def test_buildgrid(self):
        gridroutes = GridRoutes(3)
        self.assertEqual(12, gridroutes.grid.number_of_edges())
        self.assertEqual(9, gridroutes.grid.number_of_nodes())

