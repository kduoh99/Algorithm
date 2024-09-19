import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        int ans = 0;

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.charAt(0) == '-')
                break;
            else if (s.charAt(0) == '+')
                continue;
            ans += Integer.parseInt(s);
        }

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.charAt(0) == '-' || s.charAt(0) == '+')
                continue;
            ans -= Integer.parseInt(s);
        }

        System.out.println(ans);
        br.close();
    }
}