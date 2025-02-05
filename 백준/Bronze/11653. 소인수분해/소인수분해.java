import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		long N = Integer.parseInt(br.readLine());

		int num = 2;
		while (true) {
			if (N == 1) break;
			if (N % num == 0) {
				N /= num;
				sb.append(num).append("\n");
			} else {
				num++;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
