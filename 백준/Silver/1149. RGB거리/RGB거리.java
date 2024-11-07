import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int R = 0, G = 1, B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            cost[i][R] += Math.min(cost[i - 1][G], cost[i - 1][B]);
            cost[i][G] += Math.min(cost[i - 1][R], cost[i - 1][B]);
            cost[i][B] += Math.min(cost[i - 1][R], cost[i - 1][G]);
        }

        System.out.println(Math.min(cost[N - 1][R], Math.min(cost[N - 1][G], cost[N - 1][B])));
        br.close();
    }
}