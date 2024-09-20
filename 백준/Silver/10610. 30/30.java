import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] N = br.readLine().toCharArray();
        int[] dCount = new int[SIZE];
        int total = 0;
        boolean flag = false;

        for (char digit : N) {
            int dNum = digit - '0';
            dCount[dNum]++;
            total += dNum;
            
            if (dNum == 0) {
                flag = true;
            }
        }

        if (!flag || total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (dCount[i] > 0) {
                sb.append(i);
                dCount[i]--;
            }
        }

        System.out.println(sb);
        br.close();
    }
}