import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		int M = Integer.parseInt(br.readLine());
		int value;

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "add":
					value = Integer.parseInt(st.nextToken());
					if (!list.contains(value))
						list.add(value);
					break;
				case "remove":
					value = Integer.parseInt(st.nextToken());
					if (list.contains(value))
						list.remove(list.indexOf(value));
					break;
				case "check":
					value = Integer.parseInt(st.nextToken());
					if (list.contains(value))
						sb.append("1\n");
					else
						sb.append("0\n");
					break;
				case "toggle":
					value = Integer.parseInt(st.nextToken());
					if (list.contains(value))
						list.remove(list.indexOf(value));
					else
						list.add(value);
					break;
				case "all":
					list.clear();
					for (int j = 0; j <= 20; j++) {
						list.add(j);
					}
					break;
				case "empty":
					list.clear();
					break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
