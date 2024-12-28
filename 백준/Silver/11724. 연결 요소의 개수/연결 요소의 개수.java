import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int N;

	static void dfs(int val) {
		visited[val] = true;
		
		for (int i = 1; i <= N; i++) {
			if (arr[val][i] == 1 && !visited[i])
				dfs(i);
		}	
	}
	
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		var st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				dfs(i);
				cnt++;
			}
		}	
		System.out.println(cnt);
		br.close();
	}
}