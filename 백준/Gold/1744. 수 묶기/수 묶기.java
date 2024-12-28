import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> pn = new ArrayList<>();
		List<Integer> nn = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());

			if (value > 0) {
				pn.add(value);
			} else {
				nn.add(value);
			}
		}

		pn.sort(Collections.reverseOrder());
		Collections.sort(nn);
		int ans = 0;

		for (int i = 0; i < pn.size() - 1; i += 2) {
			if (pn.get(i) == 1 || pn.get(i + 1) == 1) {
				ans += pn.get(i) + pn.get(i + 1);
			} else {
				ans += pn.get(i) * pn.get(i + 1);
			}
		}

		if (pn.size() % 2 == 1)
			ans += pn.get(pn.size() - 1);

		for (int i = 0; i < nn.size() - 1; i += 2)
			ans += nn.get(i) * nn.get(i + 1);

		if (nn.size() % 2 == 1)
			ans += nn.get(nn.size() - 1);

		System.out.println(ans);
		br.close();
	}
}
