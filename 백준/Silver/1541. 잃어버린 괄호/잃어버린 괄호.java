import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        int ans = 0;
        boolean flag = false;

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("+")) {
                continue;
            } else if (s.equals("-")) {
                flag = true;
            } else {
                int num = Integer.parseInt(s);
                ans += flag ? -num : num;
            }
        }

        System.out.println(ans);
        br.close();
    }
}