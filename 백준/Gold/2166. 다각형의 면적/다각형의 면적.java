import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }
        // 신발끈 공식
        long sumA = 0L, sumB = 0L;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            sumA += (long) xy[i][0] * xy[next][1];
            sumB += (long) xy[next][0] * xy[i][1];
        }

        System.out.printf("%.1f%n", Math.abs(sumA - sumB) / 2.0);
        br.close();
    }
}
