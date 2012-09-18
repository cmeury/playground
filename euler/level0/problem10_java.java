package level0;

public class problem10_java {

	public long findSumOfPrimesBelow(int size) {
		boolean[] numbers = new boolean[size];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = true;
		}
		int p = 2;
		long sum = 0; // we don't count the 1 according to the problem description
		boolean found = true;
		while (found) {
			sum += p;
			for(int i = p+p; i<size; i += p) {
				numbers[i] = false;
			}
			found = false;
			for(int i = p+1; i<size; i++) {
				if(numbers[i] == true) {
					p = i;
					found = true;
					break;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		problem10_java problem10java = new problem10_java();
		System.out.println(problem10java.findSumOfPrimesBelow(2000000));
	}
}
