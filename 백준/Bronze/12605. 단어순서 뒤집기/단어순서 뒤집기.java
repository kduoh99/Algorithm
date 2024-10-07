import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<String> stack = new ArrayDeque<>();

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #").append(i).append(": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
