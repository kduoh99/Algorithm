import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		var D = new long[N - 1];
		var P = new long[N];
		
		var st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			D[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		long minP = P[0];

		for (int i = 0; i < N - 1; i++) {
			if (minP > P[i])
				minP = P[i];
			
			ans += minP * D[i];
		}	
		System.out.println(ans);
		br.close();
	}
}