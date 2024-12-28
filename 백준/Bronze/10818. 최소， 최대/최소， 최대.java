import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");

		int max = Integer.parseInt(numbers[0]);
		int min = Integer.parseInt(numbers[0]);

		for (int i = 1; i < N; ++i) {
			max = Math.max(max, Integer.parseInt(numbers[i]));
			min = Math.min(min, Integer.parseInt(numbers[i]));
		}
		
		System.out.println(min + " " + max);
		br.close();
	}
}
