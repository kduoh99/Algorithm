import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int left = 0, right = N - 1;
		int leftV = 0, rightV = 0;
		int minDiff = Integer.MAX_VALUE;

		while (left < right) {
			int sum = A[left] + A[right];
			int diff = Math.abs(sum);

			if (diff < minDiff) {
				minDiff = diff;
				leftV = A[left];
				rightV = A[right];
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		sb.append(leftV).append(' ').append(rightV);
		System.out.println(sb);
		br.close();
	}
}