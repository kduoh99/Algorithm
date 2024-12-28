import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static boolean[][] visited;
    static char[][] A;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            if (N >= 0) System.arraycopy(line, 0, A[i], 0, N);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, A[i][j]);
                    cnt++;
                }
            }
        }

        sb.append(cnt).append(' ');
        cnt = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 'R')
                    A[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, A[i][j]);
                    cnt++;
                }
            }
        }

        sb.append(cnt);
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int i, int j, char color) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (A[x][y] == color && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}