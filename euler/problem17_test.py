import unittest
from problem17 import Wordify

class WordifyTest(unittest.TestCase):

    def setUp(self):
        self.wordify = Wordify()

    def zero(self):
        self.assertEqual('', self.wordify.transform(0))

    def test_single(self):
        self.assertEqual("one", self.wordify.transform(1), )
        self.assertEqual("nine", self.wordify.transform(9))

    def test_teens(self):
        self.assertEqual("eleven", self.wordify.transform(11))
        self.assertEqual("nineteen", self.wordify.transform(19))

    def test_tens(self):
        self.assertEqual("twenty", self.wordify.transform(20))
        self.assertEqual("fifty-seven", self.wordify.transform(57))
        self.assertEqual("ninety-nine", self.wordify.transform(99))

    def test_hundreds(self):
        self.assertEqual("one hundred", self.wordify.transform(100))
        self.assertEqual("one hundred and one", self.wordify.transform(101))
        self.assertEqual("one hundred and ninety-nine", self.wordify.transform(199))
        self.assertEqual("nine hundred and ninety-nine", self.wordify.transform(999))

    def test_thousands(self):
        self.assertEqual("one thousand", self.wordify.transform(1000), )
        self.assertRaises(NotImplementedError, self.wordify.transform(1001))
