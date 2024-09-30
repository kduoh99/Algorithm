import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 1;
        boolean flag = false;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            while (num <= value) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }

            if (!stack.isEmpty() && stack.peek() == value) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = true;
                break;
            }
        }
   
        System.out.println(flag ? "NO" : sb);
        br.close();
    }
}