import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		list.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0)).append('\n');

		for (int i = 1; i < N; i++) {
			if (!list.get(i).equals(list.get(i - 1)))
				sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
