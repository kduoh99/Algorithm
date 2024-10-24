import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[SIZE];
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            dp[A[i]] = dp[A[i] - 1] + 1;
            maxLen = Math.max(maxLen, dp[A[i]]);
        }

        System.out.println(maxLen);
        br.close();
    }
}