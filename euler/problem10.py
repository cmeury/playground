def find_sum_of_primes_below(size):
    numbers = [True] * (size+1)
    sum = 0
    for i in range(2, size):
        if numbers[i] == True:
            sum += i
            for j in range(i+i,size,i):
                numbers[j] = False
        i += i
    return sum

if __name__ == '__main__':
    print find_sum_of_primes_below(2000000)