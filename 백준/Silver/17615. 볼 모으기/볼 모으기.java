import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String ball = br.readLine();

        int ans = Integer.MAX_VALUE, cnt = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (flag && ball.charAt(i) == 'R')
                cnt++;

            if (ball.charAt(i) == 'B')
                flag = true;
        }
        ans = Math.min(ans, cnt);

        cnt = 0;
        flag = false;
        for (int i = 0; i < N; i++) {
            if (flag & ball.charAt(i) == 'B')
                cnt++;

            if (ball.charAt(i) == 'R')
                flag = true;
        }
        ans = Math.min(ans, cnt);

        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (flag & ball.charAt(i) == 'R')
                cnt++;

            if (ball.charAt(i) == 'B')
                flag = true;
        }
        ans = Math.min(ans, cnt);

        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (flag & ball.charAt(i) == 'B')
                cnt++;

            if (ball.charAt(i) == 'R')
                flag = true;
        }
        ans = Math.min(ans, cnt);

        System.out.println(ans);
        br.close();
    }
}
