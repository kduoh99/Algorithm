import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		String[] input;
		int total = 0;

		for (int i = 0; i < N; ++i) {
			input = br.readLine().split(" ");
			total += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
		}
		
		bw.write(X == total ? "Yes" : "No");
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
