import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = N - 1;
        int idx_left = 0, idx_right = 0;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (min >= Math.abs(sum)) {
                min = Math.abs(sum);
                idx_left = left;
                idx_right = right;
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(arr[idx_left] + " " + arr[idx_right]);
        br.close();
    }
}
