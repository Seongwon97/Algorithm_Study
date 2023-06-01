package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/1644
// 소수의 연속합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> primeNumbers = findPrimes(N);

        int count = 0;
        int start = 0;
        int end = 0;
        if (primeNumbers.size() == 0) {
            System.out.println(0);
            return;
        }
        int sum = primeNumbers.get(start);

        while (start <= end) {
            if (sum == N) {
                count++;
                sum -= primeNumbers.get(start);
                start++;
            } else if (sum < N) {
                end++;
                if (end >= primeNumbers.size()) {
                    break;
                }
                sum += primeNumbers.get(end);
            } else {
                sum -= primeNumbers.get(start);
                start++;
            }
        }

        System.out.println(count);
    }

    private static List<Integer> findPrimes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        int sqrtN = (int) Math.sqrt(N);

        for (int i = 2; i <= sqrtN; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2 * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }
}
/*
Input
20

Output
0
---
Input
3

Output
1
---
Input
41

Output
3
---
Input
53

Output
2
*/
