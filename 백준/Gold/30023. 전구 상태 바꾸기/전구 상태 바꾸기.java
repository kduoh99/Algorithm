import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] blub = br.readLine().toCharArray();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            char[] newBlub = blub.clone();

            for (int j = 1; j < N - 2; j++) {
                while (newBlub[0] != newBlub[j]) {
                    cnt++;
                    shift(j, newBlub);
                }
            }

            if (newBlub[0] == newBlub[N - 1] && newBlub[0] == newBlub[N - 2]) {
                answer = Math.min(answer, cnt + i);
            }

            shift(0, blub);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    private static void shift(int start, char[] newBlub) {
        for (int i = start; i < start + 3; i++) {
            if (newBlub[i] == 'R') {
                newBlub[i] = 'G';
            } else if (newBlub[i] == 'G') {
                newBlub[i] = 'B';
            } else {
                newBlub[i] = 'R';
            }
        }
    }
}
