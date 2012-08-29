def read_input(filename):
    inputFile = open(filename,'r')
    numbers = []
    for line in inputFile:
        numbers.append(line.strip())
    return numbers

def building_blocks(numbers):
    Ones = numbers[:9]
    SingleTens = numbers[9:19]
    Tens = numbers[19:27]
    A_Hundred = numbers[27]
    A_And = numbers[28]
    A_Thousand = numbers[29]
    return Ones,SingleTens,Tens,A_Hundred,A_And,A_Thousand

def check_Hundred(Ones,SingleTens,Tens,A_Hundred,A_And):        # check from 100 to 999 ?
    tmp = []
    for i in range(0,10):
        tmp.extend( [ len(x) for x in Tens] * 10 )              # check 20-90
        tmp.extend( [ len(x) for x in Ones ] * 9 )          # check single digits (without 10-19)
        tmp.extend( [ len(x) for x in SingleTens ])        # check from 10-19
    tmp.append(891 * len(A_And))
    tmp.append(900 * len(A_Hundred))              # all "ands" and "hundreds"
    tmp.extend( [ 100 * len(x) for x in Ones ] )            # all "X" hundred ..
    return tmp

if __name__ == "__main__":
    Liste = []
    test = read_input('problem17_meli_input.txt')
    Ones,SingleTens,Tens,A_Hundred,A_And,A_Thousand = building_blocks(test)
    Liste.extend([len(A_Thousand), len(Ones[0])]) # one thousand
    Liste.extend(check_Hundred(Ones,SingleTens,Tens,A_Hundred,A_And))
    print sum(Liste)