import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        StringBuilder sb = new StringBuilder();

        for (char c : ch) {
            sb.append(c);

            if (sb.length() >= bombLen) {
                boolean flag = true;

                for (int i = 0; i < bombLen; i++) {
                    if (sb.charAt(sb.length() - bombLen + i) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
        br.close();
    }
}
