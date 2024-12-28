import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] minTree, maxTree, nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nums = new int[N + 1];
		minTree = new int[N * 4];
		maxTree = new int[N * 4];

		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(findMin(a, b)).append(' ').append(findMax(a, b)).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			minTree[node] = nums[start];
			maxTree[node] = nums[start];
		} else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);
			minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
			maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
		}
	}

	private static int findMin(int left, int right) {
		return findMin(1, 1, nums.length - 1, left, right);
	}

	private static int findMin(int node, int start, int end, int left, int right) {
		if (left > end || right < start)
			return Integer.MAX_VALUE;

		if (left <= start && end <= right)
			return minTree[node];

		int mid = (start + end) / 2;
		return Math.min(findMin(node * 2, start, mid, left, right), findMin(node * 2 + 1, mid + 1, end, left, right));
	}

	private static int findMax(int left, int right) {
		return findMax(1, 1, nums.length - 1, left, right);
	}

	private static int findMax(int node, int start, int end, int left, int right) {
		if (left > end || right < start)
			return Integer.MIN_VALUE;

		if (left <= start && end <= right)
			return maxTree[node];

		int mid = (start + end) / 2;
		return Math.max(findMax(node * 2, start, mid, left, right), findMax(node * 2 + 1, mid + 1, end, left, right));
	}
}
