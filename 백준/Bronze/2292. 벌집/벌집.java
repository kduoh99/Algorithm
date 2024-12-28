import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());
		long room = 1, value = 1;

		while (true) {
			if (N <= value) {
				System.out.println(room);
				break;
			}
			value += room * 6;
			room++;
		}
	}
}