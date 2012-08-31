import unittest
from problem15 import GridRoutes

class GridRoutesTest(unittest.TestCase):

    def test_routes(self):
        self.assertEqual(6, GridRoutes(3).routes())
        self.assertEqual(2, GridRoutes(2).routes())

    def test_buildgrid(self):
        gridroutes = GridRoutes(3)
        self.assertEqual(12, gridroutes.grid.number_of_edges())
        self.assertEqual(9, gridroutes.grid.number_of_nodes())

