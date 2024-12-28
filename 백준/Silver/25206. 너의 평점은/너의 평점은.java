import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final int SIZE = 20;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double cTotal = 0, gTotal = 0;
		double[] credit = new double[SIZE];
		double[] grade = new double[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			String[] input = br.readLine().split(" ");
			credit[i] = Double.parseDouble(input[1]);

			switch (input[2]) {
				case "A+":
					grade[i] = 4.5;
					break;
				case "A0":
					grade[i] = 4.0;
					break;
				case "B+":
					grade[i] = 3.5;
					break;
				case "B0":
					grade[i] = 3.0;
					break;
				case "C+":
					grade[i] = 2.5;
					break;
				case "C0":
					grade[i] = 2.0;
					break;
				case "D+":
					grade[i] = 1.5;
					break;
				case "D0":
					grade[i] = 1.0;
					break;
				case "F":
					grade[i] = 0;
					break;
				case "P":
					credit[i] = 0;
					grade[i] = 0;
					break;
			}
			cTotal += credit[i];
			gTotal += credit[i] * grade[i];
		}
		
		bw.write(gTotal / cTotal + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
