import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<Integer> arr = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr.add(Integer.parseInt(br.readLine()));
			sum += arr.get(i);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				sum -= (arr.get(i) + arr.get(j));

				if (sum == 100) {
					arr.remove(i);
					arr.remove(j - 1);

					for (int k : arr)
						sb.append(k).append('\n');

					System.out.println(sb);
					return;
				} else
					sum += (arr.get(i) + arr.get(j));
			}
		}
	}
}
