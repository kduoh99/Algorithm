import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                ans += set.size();
                set = new HashSet<>();
            } else {
                set.add(str);
            }
        }

        System.out.println(ans + set.size());
        br.close();
    }
}
