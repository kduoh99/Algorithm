import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long N = Integer.parseInt(input[0]);
		long M = Integer.parseInt(input[1]);

		System.out.println(Math.abs(N - M));
		br.close();
	}
}