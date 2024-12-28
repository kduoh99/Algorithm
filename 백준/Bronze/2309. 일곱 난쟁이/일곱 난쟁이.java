import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}

		Collections.sort(list);

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				sum -= (list.get(i) + list.get(j));

				if (sum == 100) {
					list.remove(i);
					list.remove(j - 1);

					for (int k : list)
						sb.append(k).append('\n');

					System.out.println(sb);
					return;
				} else {
					sum += (list.get(i) + list.get(j));
				}
			}
		}
	}
}