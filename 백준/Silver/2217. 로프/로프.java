import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[N];

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope, Collections.reverseOrder());
		int max = rope[0];
		
		for (int j = 1; j < N; j++) {
			max = Math.max(max, rope[j] * (j + 1));
		}
		
		System.out.println(max);
		br.close();
	}
}