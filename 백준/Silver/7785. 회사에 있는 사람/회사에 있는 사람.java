import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Map<String, String> map = new HashMap<>(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String record = st.nextToken();

			if (record.equals("enter"))
				map.put(name, record);
			else
				map.remove(name);
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort(Collections.reverseOrder());

		for (String s : keySet)
			sb.append(s).append('\n');

		System.out.println(sb);
		br.close();
	}
}
