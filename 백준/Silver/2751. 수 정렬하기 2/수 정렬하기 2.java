import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		byte[] cnt = new byte[2 * SIZE + 1];

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			cnt[val + SIZE] += 1;
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == 1)
				sb.append(i - SIZE).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}
