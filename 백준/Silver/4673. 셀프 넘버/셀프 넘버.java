public class Main {
	public static void main(String[] args) {
		final int SIZE = 10_000;
		StringBuilder sb = new StringBuilder();
		boolean[] selfNumbers = new boolean[SIZE];

		for (int i = 1; i < SIZE; i++) {
			for (int j = 0; j < i; j++) {
				int num = j;
				int dSum = 0;

				while (num != 0) {
					dSum += num % 10;
					num /= 10;
				}
				if (dSum + j == i) {
					selfNumbers[i - 1] = true;
				}
			}
		}

		for (int k = 1; k < SIZE; k++) {
			if (!selfNumbers[k - 1])
				sb.append(k).append("\n");
		}
		
		System.out.println(sb);
	}
}
