import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] A, tmp;
	private static long cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		tmp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		mergeSort(0, N - 1);
		System.out.println(cnt);
		br.close();
	}

	private static void merge(int start, int mid, int end) {
		int i = start, j = start, k = mid + 1;

		while (j <= mid && k <= end) {
			if (A[k] < A[j]) {
				tmp[i++] = A[k++];
				cnt += (mid - j + 1);
			} else {
				tmp[i++] = A[j++];
			}
		}

		while (j <= mid)
			tmp[i++] = A[j++];

		while (k <= end)
			tmp[i++] = A[k++];

		System.arraycopy(tmp, start, A, start, end - start + 1);
	}

	private static void mergeSort(int start, int end) {
		if (start == end) return;

		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		merge(start, mid, end);
	}
}
