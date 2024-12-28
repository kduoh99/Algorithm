import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> students = new ArrayList<>();
		String[] names = new String[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			students.add(new int[] {i, d, m, y});
		}

		students.sort((o1, o2) -> {
			if (o1[3] != o2[3]) {
				return o1[3] - o2[3];
			} else if (o1[2] != o2[2]) {
				return o1[2] - o2[2];
			} else {
				return o1[1] - o2[1];
			}
		});

		StringBuilder sb = new StringBuilder();
		sb.append(names[students.get(N - 1)[0]]).append('\n').append(names[students.get(0)[0]]);
		System.out.println(sb);
		br.close();
	}
}