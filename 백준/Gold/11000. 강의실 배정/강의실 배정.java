import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<int[]> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr.add(new int[]{S, T});
        }

        arr.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr.get(0)[1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr.get(i)[0]) {
                pq.poll();
            }
            pq.add(arr.get(i)[1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}