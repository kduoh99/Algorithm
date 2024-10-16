import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 3; i > 0; i--) {
            String str = br.readLine();
            if (!Character.isDigit(str.charAt(0))) continue;

            int value = Integer.parseInt(str) + i;
            if (value % 3 == 0 && value % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (value % 3 == 0) {
                System.out.println("Fizz");
            } else if (value % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(value);
            }
            return;
        }
        br.close();
    }
}
