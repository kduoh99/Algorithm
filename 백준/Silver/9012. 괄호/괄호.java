import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] ch = br.readLine().toCharArray();
            boolean flag = false;

            for (char c : ch) {
                if (c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    flag = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            sb.append(stack.isEmpty() && !flag ? "YES" : "NO").append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}