import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final int SIZE = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] numbers = new String[SIZE];
		for (int i = 0; i < SIZE; ++i) {
			numbers[i] = br.readLine();
		}

		int max = Integer.parseInt(numbers[0]);
		int index = 1;
		for (int j = 0; j < SIZE; ++j) {
			if (max < Integer.parseInt(numbers[j])) {
				max = Integer.parseInt(numbers[j]);
				index = j + 1;
			}
		}
		
		bw.write(max + "\n" + index + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}