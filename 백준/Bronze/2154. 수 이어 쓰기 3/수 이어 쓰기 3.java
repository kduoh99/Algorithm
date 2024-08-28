import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Integer.parseInt(N); i++) {
			sb.append(i + 1);
		}
		System.out.println(sb.indexOf(N) + 1);
		br.close();
	}
}