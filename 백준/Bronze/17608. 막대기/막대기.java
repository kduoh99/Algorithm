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

        int count = 0, maxHeight = 0;
        while (!stack.isEmpty()) {
            int height = stack.pollLast();
            if (maxHeight < height) {
                count++;
                maxHeight = height;
            }
        }

        System.out.println(count);
        br.close();
    }
}
