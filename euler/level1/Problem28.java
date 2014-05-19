package level1;

/**
 * <a href="https://projecteuler.net/problem=28">Number spiral diagonals.</a>
 */
public class Problem28 {

    public static void main(String[] args) {
        System.out.println("5x5 = " + spiralDiagonalsSum(5));
        System.out.println("1001x1001 = " + spiralDiagonalsSum(1001));
    }

    private static int spiralDiagonalsSum(int length) {
        int sum = 1; // the first integer '1' is guaranteed to be part of the diagonals, we add it right away

        // positions
        int step = 0;
        int start = 0;

        do {
            step += 2;
            sum += start + (step * 1) + 1;
            sum += start + (step * 2) + 1;
            sum += start + (step * 3) + 1;
            sum += start + (step * 4) + 1;
            start = start + (step * 4);
        } while(start < Math.pow(length, 2) - 1);

        return sum;
    }

}
