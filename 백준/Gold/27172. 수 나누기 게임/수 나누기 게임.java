import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] X = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] S = new int[SIZE];
        Arrays.fill(S, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            S[X[i]] = 0;
        }

        for (int x : X) {
            for (int i = x * 2; i < SIZE; i += x) {
                if (S[i] != Integer.MIN_VALUE) {
                    S[x]++; S[i]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : X) {
            sb.append(S[x]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
