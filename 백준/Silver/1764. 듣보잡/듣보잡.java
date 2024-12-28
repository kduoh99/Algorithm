import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();
		
		var st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> setA = new HashSet<>();
		Set<String> setB = new HashSet<>();
		
		for (int i = 0; i < N; i++)
			setA.add(br.readLine());
		
		for (int i = 0; i < M; i++)
			setB.add(br.readLine());
	
		ArrayList<String> arr = new ArrayList<>();		
		for (String s : setA) {
			if (setB.contains(s))
				arr.add(s);
		}
		sb.append(arr.size()).append('\n');
		Collections.sort(arr);
		
		for (String s : arr)
			sb.append(s).append('\n');

		System.out.println(sb.toString());
		br.close();
	}
}