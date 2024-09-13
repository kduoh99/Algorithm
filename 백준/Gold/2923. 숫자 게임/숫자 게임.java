import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int[] countA = new int[MAX];
        int[] countB = new int[MAX];
        int[] maxSums = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            countA[a]++;
            countB[b]++;

            int leftIdx = 1, rightIdx = MAX - 1;
            int lc = countA[leftIdx], rc = countB[rightIdx];

            while (leftIdx <= MAX - 1 && rightIdx >= 1) {
                while (leftIdx < MAX - 1 && lc == 0) {
                    leftIdx++;
                    lc = countA[leftIdx];
                }

                while (rightIdx > 1 && rc == 0) {
                    rightIdx--;
                    rc = countB[rightIdx];
                }

                if (rightIdx == 1 && rc == 0) {
                    break;
                }

                maxSums[i] = Math.max(maxSums[i], leftIdx + rightIdx);

                if (lc <= rc) {
                    rc -= lc;
                    lc = 0;
                } else {
                    lc -= rc;
                    rc = 0;
                }
            }

            sb.append(maxSums[i]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
