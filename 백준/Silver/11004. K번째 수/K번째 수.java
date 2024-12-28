import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];

		for (int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(st.nextToken());

		System.out.println(select(A, K));
		br.close();
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private static int partitionBy0(int[] A) {
		int i = -1;

		for (int j = 0; j < A.length; j++)
			if (A[j] < 0)
				swap(A, ++i, j);
		return i + 1;
	}

	private static void countingSort(int[] A, int start, int end, int nth) {
		int[] cnt = new int[256];

		for (int i = start; i <= end; ++i) {
			int value = A[i];
			int digit = value >> (nth * 8) & 0xFF;
			++cnt[digit];
		}

		int[] idx = new int[256];
		idx[0] = 0;

		for (int i = 1; i < idx.length; ++i)
			idx[i] = idx[i - 1] + cnt[i - 1];

		int[] tmp = new int[end - start + 1];

		for (int i = start; i <= end; ++i) {
			int value = A[i];
			int digit = value >> (nth * 8) & 0xFF;
			tmp[idx[digit]++] = value;
		}

		for (int i = start; i <= end; ++i)
			A[i] = tmp[i - start];
	}

	private static void radixSort(int[] A) {
		int mid = partitionBy0(A);

		for (int i = 0; i < 4; ++i) {
			countingSort(A, 0, mid - 1, i);
			countingSort(A, mid, A.length - 1, i);
		}
	}

	private static int select(int[] A, int nth) {
		radixSort(A);
		return A[nth - 1];
	}
}
