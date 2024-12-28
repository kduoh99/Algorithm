import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]>[] graph;
	static boolean[] visited;
	static int maxD, farthestN;
	
	static void dfs(int start) {
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {start, 0});
		
		while (!stack.isEmpty()) {
			int[] current = stack.pop();
			int N = current[0];
			int D = current[1];
			visited[N] = true;
			
			if (maxD < D) {
				maxD = D;
				farthestN = N;
			}
			 
			for (int[] next : graph[N]) {
				int nextN = next[0];
				int edgeW = next[1];
				
				if (!visited[nextN])
					stack.push(new int[] {nextN, D + edgeW});
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		StringTokenizer st;
		
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break;
				int edgeW = Integer.parseInt(st.nextToken());
				graph[from].add(new int[] {to, edgeW});
			}
		}
	
		dfs(1);		
		visited = new boolean[V + 1];
		maxD = 0;
		dfs(farthestN);
		
		System.out.println(maxD);
		br.close();
	}
}