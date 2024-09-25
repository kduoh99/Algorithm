import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] peaks = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            peaks[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, kill = 0, peak = peaks[0];
        for (int i = 1; i < N; i++) {
            if (peaks[i] < peak) {
                kill++;
            } else {
                ans = Math.max(ans, kill);
                peak = peaks[i];
                kill = 0;
            }
        }

        ans = Math.max(ans, kill);
        System.out.println(ans);
        br.close();
    }
}
