import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> iMap = new HashMap<>();
		Map<String, Integer> sMap = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			iMap.put(i, name);
			sMap.put(name, i);
		}

		for (int i = 1; i <= M; i++) {
			String str = br.readLine();

			if (check(str)) {
				sb.append(iMap.get(Integer.parseInt(str))).append('\n');
			} else {
				sb.append(sMap.get(str)).append('\n');
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean check(String s) {
		boolean isNumber = false;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				isNumber = true;
			} else {
				break;
			}
		}
		
		return isNumber;
	}
}
