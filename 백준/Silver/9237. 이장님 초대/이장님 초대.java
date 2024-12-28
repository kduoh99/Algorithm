import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] T = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			T[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(T, Collections.reverseOrder());
		for (int i = 0; i < N; i++)
			T[i] += i + 1;

		Arrays.sort(T, Collections.reverseOrder());
		System.out.println(T[0] + 1);
		br.close();
	}
}