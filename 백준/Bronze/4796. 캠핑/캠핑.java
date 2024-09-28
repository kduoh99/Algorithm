import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            if (L == 0) break;
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int ans = V / P * L + Math.min(V % P, L);
            cnt++;

            sb.append("Case ").append(cnt).append(": ").append(ans).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}