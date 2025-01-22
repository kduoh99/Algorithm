import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] S = new int[N];

		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, count = 0, answer = 0;

		while (right < N) {
			if (S[right] % 2 != 0)
				count++;

			while (count > K) {
				if (S[left] % 2 != 0)
					count--;
				left++;
			}

			answer = Math.max(answer, right - left + 1 - count);
			right++;
		}

		System.out.println(answer);
		br.close();
	}
}
