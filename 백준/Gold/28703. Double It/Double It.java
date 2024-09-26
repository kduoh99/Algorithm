import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxVal = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            pq.offer(val);
            maxVal = Math.max(maxVal, val);
        }

        int tmp = maxVal;
        int minDiff = maxVal - pq.peek();

        while (pq.peek() < maxVal) {
            int minVal = pq.poll();
            minDiff = Math.min(minDiff, tmp - minVal);
            tmp = Math.max(maxVal, minVal * 2);
            pq.offer(minVal * 2);
        }

        System.out.println(Math.min(minDiff, tmp - pq.peek()));
        br.close();
    }
}
