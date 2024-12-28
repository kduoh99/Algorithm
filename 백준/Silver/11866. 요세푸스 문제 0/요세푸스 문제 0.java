import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> numbers = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			numbers.add(i);
		}

		int c = 0;
		while (!numbers.isEmpty()) {
			c = (c + K - 1) % numbers.size();
			result.add(numbers.remove(c));
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));

			if (i < result.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}
}