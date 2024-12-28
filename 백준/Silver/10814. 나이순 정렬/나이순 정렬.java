import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(age, name));
		}
		
		list.sort(Comparator.comparingInt(m -> m.age));
		for (Member m : list) {
			bw.write(m.print() + "\n");
		}
		bw.close();
		br.close();
	}
}

class Member {
	int age;
	String name;

	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public String print() {
		return age + " " + name;
	}
}
