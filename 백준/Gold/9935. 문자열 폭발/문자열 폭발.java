import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();
        String bomb = br.readLine();
        int bomb_len = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (char c : ch) {
            stack.push(c);
            int size = stack.size();

            if (size >= bomb_len) {
                boolean flag = true;

                for (int i = 0; i < bomb_len; i++) {
                    if (stack.get(size - bomb_len + i) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < bomb_len; i++) {
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse());
        br.close();
    }
}