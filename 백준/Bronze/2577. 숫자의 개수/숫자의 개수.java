import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = 1;
		for (int i = 0; i < 3; i++) {
			input *= Integer.parseInt(br.readLine());
		}

		String result = String.valueOf(input);
		int[] numbers = new int[10];

		for (int i = 0; i < result.length(); i++) {
			for (int j = 0; j < 10; j++) {
				int digit = Character.getNumericValue(result.charAt(i));
				if (digit == j)
					numbers[j]++;
			}
		}
		
		for (int j = 0; j < 10; j++) {
			bw.write(numbers[j] + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}