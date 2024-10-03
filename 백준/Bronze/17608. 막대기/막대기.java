import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0, top = 0;
        while (!stack.isEmpty()) {
            if (top < stack.peekLast()) {
                top = stack.pollLast();
                count++;
                continue;
            }
            stack.pollLast();
        }

        System.out.println(count);
        br.close();
    }
}
