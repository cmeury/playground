class MaxNumPrime:

    def __init__(self):
        self.prime_memo = {}
        self.consec_memo = {}

    def check_prime(self, x):
        if x in self.prime_memo:
            result = self.prime_memo[x]
        else:
            result = True
            for i in range(2,x,1):
                if x % i == 0:
                    result = False
            self.prime_memo[x] = result
        return result

    def num_consecutive_primes(self, a, b):
        if str(a) + str(b) in self.consec_memo:
            result = self.consec_memo[str(a) + str(b)]
        elif str(b) + str(a) in self.consec_memo:
            result = self.consec_memo[str(b) + str(a)]
        else:
            count = 0
            n = 0
            while True:
                x = pow(n, 2) + (a * n) + b
                if self.check_prime(x):
                    count += 1
                    n += 1
                else:
                    break
            self.consec_memo[str(a) + str(b)] = count
            result = count
        return result

if __name__ == '__main__':
    mnp = MaxNumPrime()
    max_num = 0
    max_a = 0
    max_b = 0
    for a in range(-999, 1000):
        print "a: " + str(a)
        for b in range (-999, 1000):
            num = mnp.num_consecutive_primes(a, b)
            if num > max_num:
                max_num = 0
                max_a = a
                max_b = b
    print str(max_a * max_b)


# incorrect = 96903