import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : ch) {
            stack.push(c);

            if (stack.size() >= 4) {
                char fourth = stack.pop();
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();

                if (first == 'P' && second == 'P' && third == 'A' && fourth == 'P') {
                    stack.push('P');
                } else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                    stack.push(fourth);
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
        br.close();
    }
}
