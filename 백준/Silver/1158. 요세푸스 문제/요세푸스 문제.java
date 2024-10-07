import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();
		
		var st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> A = new ArrayList<>();
		Deque<Integer> Q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++)
			A.add(i);
		
		int c = 0;
		while (!A.isEmpty()) {
			c = (c + K - 1) % A.size();
			Q.add(A.remove(c));
		}
		
		sb.append("<");
		while (!Q.isEmpty())
			sb.append(Q.size() > 1 ? Q.remove() + ", " : Q.remove());
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}
}