import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] N = new int[T];
		
		for (int i = 0; i < T; i++) {
			N[i] = Integer.parseInt(br.readLine());
			int num = N[i] + 1;
			int div = N[i] % 100;

			if (num % div == 0)
				sb.append("Good\n");
			else
				sb.append("Bye\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}