import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                minLen = Math.min(minLen, end - start);
                sum -= A[start++];
            } else if (end == N) {
                break;
            } else {
                sum += A[end++];
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
        br.close();
    }
}
