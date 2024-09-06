import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (check(br.readLine()))
                count++;
        }

        System.out.println(count);
        br.close();
    }

    private static boolean check(String str) {
        final int SIZE = str.length();
        boolean[] al = new boolean[26];
        int prev = 0;

        for (int i = 0; i < SIZE; i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (!al[now - 'a']) {
                    al[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}