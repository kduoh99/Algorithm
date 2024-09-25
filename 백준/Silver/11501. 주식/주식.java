import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = 0;
            int maxPrice = 0;

            for (int k = N - 1; k >= 0; k--) {
                if (A[k] > maxPrice) {
                    maxPrice = A[k];
                } else {
                    maxProfit += maxPrice - A[k];
                }
            }
            sb.append(maxProfit).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}