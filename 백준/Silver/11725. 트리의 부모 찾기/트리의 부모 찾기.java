import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] A;
    private static int[] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int child : A[start]) {
            if (!visited[child]) {
                parent[child] = start;
                dfs(child);
            }
        }
    }
}