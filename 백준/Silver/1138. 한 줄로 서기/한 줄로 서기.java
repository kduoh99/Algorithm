import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cond = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cond[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (cnt < N) {
            for (int i = 0; i < N; i++) {
                if (cond[i] == 0) {
                    sb.append(i + 1).append(' ');
                    cnt++;

                    for (int j = i; j >= 0; j--) {
                        cond[j]--;
                    }
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
