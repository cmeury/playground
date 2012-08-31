public class problem10_java {

	public int findSumOfPrimesBelow(int size) {
		boolean[] numbers = new boolean[size + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = true;
		}
		int p = 2;
		int sum = 1; // 1 is a prime number
		while (true) {
			sum += p;
			System.out.println(p + " -> " + sum);
			for(int i = p+p; i<size; i += p) {
				numbers[i] = false;
			}
			boolean found = false;
			for(int i = p+1; i<size; i++) {
				if(numbers[i] == true) {
					p = i;
					found = true;
					break;
				}
			}
			if(!found) {
				break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		problem10_java problem10java = new problem10_java();
		System.out.println(problem10java.findSumOfPrimesBelow(30));
	}
}
