import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Deque<Character> stack = new ArrayDeque<>();
            String s = br.readLine();
            boolean flag = false;

            if (s.equals(".")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            sb.append((stack.isEmpty() && !flag) ? "yes" : "no").append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
}