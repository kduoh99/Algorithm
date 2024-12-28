import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1) break;

			int[] tmp = new int[n/2];
			int count = 0;

			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					tmp[count] = i;
					count++;
				}
			}

			int sum = 0;
			for (int i : tmp)
				sum += i;

			if (n == sum) {
				sb.append(n).append(" = ");
				for (int k = 0; k < count - 1; k++) {
					sb.append(tmp[k]).append(" + ");
				}
				sb.append(tmp[count - 1]).append("\n");
			}
			else {
				sb.append(n).append(" is NOT perfect.\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
