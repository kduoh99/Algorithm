import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine()) % 3;
		switch (x) {
			case 1:
				System.out.println('U');
				break;
			case 2:
				System.out.println('O');
				break;
			case 0:
				System.out.println('S');
				break;
		}
	}
}
