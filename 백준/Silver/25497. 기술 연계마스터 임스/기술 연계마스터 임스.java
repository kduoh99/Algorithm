import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] skills = br.readLine().toCharArray();

        int lCount = 0, sCount = 0;
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            char op = skills[i];

            switch (op) {
                case 'L':
                    lCount++;
                    break;
                case 'R':
                    if (lCount > 0) {
                        lCount--;
                        count++;
                    } else {
                        flag = true;
                    }
                    break;
                case 'S':
                    sCount++;
                    break;
                case 'K':
                    if (sCount > 0) {
                        sCount--;
                        count++;
                    } else {
                        flag = true;
                    }
                    break;
                default:
                    count++;
            }

            if (flag) {
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}