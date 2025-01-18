import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] belt = new int[N];

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int[] check = new int[d + 1];
		int answer, count = 0;

		for (int i = 0; i < k; i++) {
			if (check[belt[i]]++ == 0)
				count++;
		}
		answer = count + (check[c] == 0 ? 1 : 0);

		for (int i = 0; i < N; i++) {
			if (--check[belt[i]] == 0)
				count--;

			if (check[belt[(i + k) % N]]++ == 0)
				count++;

			answer = Math.max(answer, count + (check[c] == 0 ? 1 : 0));
		}

		System.out.println(answer);
		br.close();
	}
}
