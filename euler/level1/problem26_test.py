import unittest
from problem26 import Recurring

class Problem26Test(unittest.TestCase):

    def test_recurring(self):
        recurring = Recurring()
        self.assertEqual("", recurring.check_recurring("19374"))
        self.assertEqual("1", recurring.check_recurring("111"))
        self.assertEqual("12", recurring.check_recurring("121212"))
        self.assertEqual("6", recurring.check_recurring("666"))
        self.assertEqual("583", recurring.check_recurring("583583"))
        self.assertEqual("789", recurring.check_recurring("6789789"))
        self.assertEqual("34", recurring.check_recurring("2173913434"))

    def test_repeating_number_not_recurring(self):
        recurring = Recurring()
        self.assertEqual("3831417624521727969348659", recurring.check_recurring("3831417624521727969348659383141762452172796934865938314176245"))
