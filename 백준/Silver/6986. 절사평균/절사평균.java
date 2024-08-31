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
        int K = Integer.parseInt(st.nextToken());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);

        double sum = 0;
        for (int i = K; i < N - K; i++) {
            sum += arr[i];
        }
        double tAVG = sum / (N - K * 2);

        for (int i = 0; i < K; i++) {
            arr[i] = arr[K];
            arr[N - i - 1] = arr[N - K - 1];
        }

        sum = 0;
        for (double score : arr) {
            sum += score;
        }
        double aAVG = sum / N;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", tAVG)).append('\n');
        sb.append(String.format("%.2f", aAVG));

        System.out.println(sb);
        br.close();
    }
}
