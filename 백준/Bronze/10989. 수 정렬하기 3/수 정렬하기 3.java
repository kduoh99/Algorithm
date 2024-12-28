import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int SIZE = 10_001;
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[SIZE];

		for (int i = 0; i < N; i++) {
			short num = Short.parseShort(br.readLine());
			cnt[num]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < cnt[i]; j++)
				sb.append(i).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
