import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int PARTS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ipAddr = new int[n][PARTS];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");

            for (int j = 0; j < PARTS; j++) {
                ipAddr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getNetworkInfo(ipAddr, n);
        br.close();
    }

    private static void getNetworkInfo(int[][] ipAddr, int n) {
        StringBuilder networkAddr = new StringBuilder();
        StringBuilder networkMask = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < PARTS; i++) {
            int min = ipAddr[0][i];
            int max = ipAddr[0][i];

            for (int j = 1; j < n; j++) {
                min &= ipAddr[j][i];
                max |= ipAddr[j][i];
            }

            if (!flag) {
                networkAddr.append(min);
                networkMask.append(255 - (max - min));
            } else {
                networkAddr.append(0);
                networkMask.append(0);
            }

            if (i < 3) {
                networkAddr.append('.');
                networkMask.append('.');
            }

            if (min != max) {
                flag = true;
            }
        }

        System.out.println(networkAddr);
        System.out.println(networkMask);
    }
}
