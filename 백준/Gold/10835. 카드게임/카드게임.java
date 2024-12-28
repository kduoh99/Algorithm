import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A, B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        System.out.println(sol(0, 0));
        br.close();
    }

    static int sol(int i, int j) {
        if (i == N || j == N)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Math.max(sol(i + 1, j + 1), sol(i + 1, j));

        if (A[i] > B[j])
            dp[i][j] = Math.max(dp[i][j], sol(i, j + 1) + B[j]);

        return dp[i][j];
    }
}