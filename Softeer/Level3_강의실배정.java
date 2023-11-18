import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int N = Integer.parseInt(br.readLine());
			List<Lecture> lectures = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				lectures.add(new Lecture(start, end));
			}

			int count = 0;
			int startTime = 0;

			Collections.sort(lectures);

			for (Lecture l : lectures) {
				if (startTime <= l.start) {
					count++;
					startTime = l.end;
				}
			}

			System.out.println(count);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
}
