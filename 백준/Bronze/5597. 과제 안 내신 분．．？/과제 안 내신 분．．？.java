import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final int SIZE = 31;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] numbers = new boolean[SIZE];
		for (int i = 0; i < SIZE - 3; ++i) {
			numbers[Integer.parseInt(br.readLine())] = true;
		}

		for (int j = 1; j < SIZE; ++j) {
			if (!numbers[j])
				bw.write(j + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}