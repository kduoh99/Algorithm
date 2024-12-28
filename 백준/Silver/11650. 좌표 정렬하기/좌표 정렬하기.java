import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Coord> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Coord(x, y));
		}
		list.sort((c1, c2) -> {
			if (c1.x > c2.x)
				return 1;
			else if (c1.x == c2.x) {
				if (c1.y > c2.y)
					return 1;
			}
			return -1;
		});
		for (Coord c : list) {
			c.print();
		}
	}
}

class Coord {
	int x, y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void print() {
		System.out.println(x + " " + y);
	}
}
