import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map.put(s, s);
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (map.containsKey(br.readLine()))
				count++;
		}
		System.out.println(count);
		br.close();
	}
}