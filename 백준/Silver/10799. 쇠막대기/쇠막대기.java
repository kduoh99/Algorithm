import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int ans = 0, cnt = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                cnt++;
            } else if (ch[i] == ')') {
                cnt--;

                if (ch[i - 1] == '(') {
                    ans += cnt;
                } else {
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}