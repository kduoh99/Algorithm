import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] graph;
    private static boolean[] visited;
    private static boolean[] isCycle;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            graph = new int[n + 1];
            visited = new boolean[n + 1];
            isCycle = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!isCycle[i]) {
                    dfs(i);
                }
            }

            sb.append(n - count).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        int next = graph[start];

        if (!visited[next]) {
            dfs(next);
        } else if (!isCycle[next]) {
            int tmp = next;
            count++;
            while (tmp != start) {
                count++;
                tmp = graph[tmp];
            }
        }

        isCycle[start] = true;
    }
}
