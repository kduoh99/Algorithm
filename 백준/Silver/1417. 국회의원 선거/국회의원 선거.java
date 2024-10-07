import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            pq.offer(pq.poll() - 1);
            dasom++;
            count++;
        }

        System.out.println(count);
        br.close();
    }
}
