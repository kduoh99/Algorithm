import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 그룹별 능력치 저장
		List<int[]> groups = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] group = new int[M];

			for (int j = 0; j < M; j++) {
				group[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(group);
			groups.add(group);
		}

		PriorityQueue<Student> pq = new PriorityQueue<>();
		int maxSkill = Integer.MIN_VALUE;
		int minDiff = Integer.MAX_VALUE;

		// 각 그룹의 첫 번째 값을 큐에 삽입
		for (int i = 0; i < N; i++) {
			int skill = groups.get(i)[0];
			pq.offer(new Student(skill, i, 0));
			maxSkill = Math.max(maxSkill, skill);
		}

		while (true) {
			Student cur = pq.poll();
			int minSkill = cur.skill;

			// 최소 차이 갱신
			minDiff = Math.min(minDiff, maxSkill - minSkill);

			// 그룹 끝에 도달하면 종료
			if (cur.idx + 1 >= M) break;

			// 다음 값 큐에 추가
			int nextSkill = groups.get(cur.group)[cur.idx + 1];
			pq.offer(new Student(nextSkill, cur.group, cur.idx + 1));

			// 최댓값 갱신
			maxSkill = Math.max(maxSkill, nextSkill);
		}

		System.out.println(minDiff);
		br.close();
	}
}

class Student implements Comparable<Student> {
	int skill, group, idx;

	public Student(int skill, int group, int idx) {
		this.skill = skill;
		this.group = group;
		this.idx = idx;
	}

	// 능력치 기준 오름차순 정렬
	@Override
	public int compareTo(Student other) {
		return Integer.compare(this.skill, other.skill);
	}
}
