import java.io.*;
import java.util.*;

public class Main {

	private static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long K = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			long N = Long.parseLong(st.nextToken());
			N *= 10;

			long result = solution(P, N);
			result *= K;
			result %= MOD;

			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static long solution(long P, long N) {
		if (N == 1) {
			return P;
		}

		long temp = solution(P, N / 2);
		if (N % 2 == 0) {
			return (temp * temp) % MOD;
		} else {
			temp = (temp * temp) % MOD;
			return (temp * P) % MOD;
		}
	}
}
