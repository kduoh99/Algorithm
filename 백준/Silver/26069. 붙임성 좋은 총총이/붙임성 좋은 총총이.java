import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		set.add("ChongChong");

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String user1 = st.nextToken();
			String user2 = st.nextToken();

			if (set.contains(user1) || set.contains(user2)) {
				set.add(user1);
				set.add(user2);
			}
		}

		System.out.println(set.size());
		br.close();
	}
}
