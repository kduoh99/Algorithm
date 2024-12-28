import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[] need = new int[4];
	private static final int[] in = new int[4];
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		char[] DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		need[0] = Integer.parseInt(st.nextToken());
		need[1] = Integer.parseInt(st.nextToken());
		need[2] = Integer.parseInt(st.nextToken());
		need[3] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < DNA.length; i++) {
			in["ACGT".indexOf(DNA[i])]++;

			if (i >= P)
				in["ACGT".indexOf(DNA[i - P])]--;
			if (i >= P - 1)
				check();
		}
		
		System.out.println(count);
		br.close();
	}

	private static void check() {
		for (int i = 0; i < 4; i++)
			if (in[i] < need[i]) return;
		count++;
	}
}
