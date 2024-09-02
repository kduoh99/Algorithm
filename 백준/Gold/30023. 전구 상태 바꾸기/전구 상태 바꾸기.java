import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] blub = br.readLine().toCharArray();

        int answer = INF;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            char[] newBlub = blub.clone();

            for (int j = 1; j < N - 2; j++) {
                while (newBlub[0] != newBlub[j]) {
                    shift(newBlub, j);
                    cnt++;
                }
            }

            if (newBlub[0] == newBlub[N - 1] && newBlub[0] == newBlub[N - 2]) {
                answer = Math.min(answer, cnt + i);
            }

            shift(blub, 0);
        }

        System.out.println(answer == INF ? -1 : answer);
        br.close();
    }

    private static void shift(char[] newBlub, int start) {
        for (int i = start; i < start + 3; i++) {
            switch (newBlub[i]) {
                case 'R':
                    newBlub[i] = 'G';   break;
                case 'G':
                    newBlub[i] = 'B';   break;
                case 'B':
                    newBlub[i] = 'R';   break;
            }
        }
    }
}
