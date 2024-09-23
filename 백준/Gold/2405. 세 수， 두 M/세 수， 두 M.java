import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        int i = 0, j = 1, ans = 0;

        while (j < n - 1) {
            ans = Math.max(ans, Math.abs(A[i] - 2 * A[j] + A[n - 1]));
            i++;
            j++;
        }

        i = 1; j = 2;
        while (j < n) {
            ans = Math.max(ans, Math.abs(A[0] - 2 * A[i] + A[j]));
            i++;
            j++;
        }

        System.out.println(ans);
        br.close();
    }
}
