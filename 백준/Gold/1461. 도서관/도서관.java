import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> pn = new ArrayList<>();
		List<Integer> nn = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (max < Math.abs(num))
				max = Math.abs(num);

			if (num > 0) {
				pn.add(num);
			} else {
				nn.add(Math.abs(num));
			}
		}

		pn.sort(Collections.reverseOrder());
		nn.sort(Collections.reverseOrder());
		int result = 0, pn_size = pn.size(), nn_size = nn.size();

		for (int i = 0; i < pn_size; i += M)
			result += pn.get(i) * 2;

		for (int i = 0; i < nn_size; i += M)
			result += nn.get(i) * 2;

		result -= max;
		System.out.println(result);
		br.close();
	}
}
