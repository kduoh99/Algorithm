import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>(N);

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            dq.poll();
            dq.offerLast(dq.poll());
        }

        System.out.println(dq.poll());
        br.close();
    }
}