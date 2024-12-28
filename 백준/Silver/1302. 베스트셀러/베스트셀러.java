import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			String B = br.readLine();
			map.put(B, map.getOrDefault(B,  0) + 1);
			max = Math.max(max, map.get(B));
		}

		List<String> list = new ArrayList<>();
		for (var e : map.entrySet()) {
			if (e.getValue() == max)
				list.add(e.getKey());
		}

		Collections.sort(list);
		System.out.println(list.get(0));
		br.close();
	}
}
