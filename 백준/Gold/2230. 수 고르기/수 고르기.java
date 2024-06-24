import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;

        int left = 0, right = 0;
        while (left < N && right < N) {
            int diff = A[right] - A[left];

            if (diff >= M) {
                ans = Math.min(ans, diff);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
