import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 1, right = 1, count = 0, size = Integer.MAX_VALUE;

		while (right <= N) {
			if (arr[right] == 1)
				count++;

			while (count >= K) {
				size = Math.min(size, right - left + 1);

				if (arr[left] == 1)
					count--;
				left++;
			}
			right++;
		}

		System.out.println(size == Integer.MAX_VALUE ? -1 : size);
		br.close();
	}
}
