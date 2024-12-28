import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			int score = Integer.parseInt(br.readLine());
			arr.add(new int[]{i, score});
		}

		arr.sort((o1, o2) -> o2[1] - o1[1]);
		int total = 0;
		int[] idx = new int[5];
		
		for (int i = 0; i < 5; i++) {
			idx[i] = arr.get(i)[0];
			total += arr.get(i)[1];
		}

		Arrays.sort(idx);
		StringBuilder sb = new StringBuilder();
		sb.append(total).append('\n');

		for (int i : idx)
			sb.append(i).append(' ');
		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
		br.close();
	}
}
