import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int[] numbers = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			numbers[i] = Integer.parseInt(input[i]);
			sum += numbers[i] * numbers[i];
		}
		bw.write((sum % 10) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}