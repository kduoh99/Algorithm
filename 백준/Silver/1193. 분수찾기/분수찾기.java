import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int cross = 1, sum = 0;

		while (true) {
			if (X <= sum + cross) {
				if (cross % 2 == 1) {
					System.out.print((cross - (X - sum - 1)) + "/" + (X - sum));
				} else {
					System.out.print((X - sum) + "/" + (cross - (X - sum - 1)));
				}
				break;
			} else {
				sum += cross;
				cross++;
			}
		}
		
		br.close();
	}
}
