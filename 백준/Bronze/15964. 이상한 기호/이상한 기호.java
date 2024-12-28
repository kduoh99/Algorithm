import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long A = Integer.parseInt(input[0]);
		long B = Integer.parseInt(input[1]);

		System.out.println((A + B) * (A - B));
		br.close();
	}
}
