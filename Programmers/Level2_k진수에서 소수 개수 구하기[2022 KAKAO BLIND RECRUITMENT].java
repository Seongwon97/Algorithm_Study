class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        sb.reverse();
        String convertedNumber = sb.toString();

        int lastIndexOf0 = -100;
        for (int i = 0; i < convertedNumber.length(); i++) {
            if (convertedNumber.charAt(i) == '0') {
                // 처음 0이 나온 경우
                if (i == lastIndexOf0 + 1) {
                    lastIndexOf0 = i;
                    continue;
                }
                if (lastIndexOf0 == -100) {
                    if (i != 0) { // P0 에 해당하는 숫자
                        long num = Long.parseLong(convertedNumber.substring(0, i));
                        if (num != 1 && isPrime(num)) {
                            answer++;
                        }
                    }
                } else { // 0P0 에 해당하는 숫자
                    long num = Long.parseLong(convertedNumber.substring(lastIndexOf0 + 1, i));
                    if (num != 1 && isPrime(num)) {
                        answer++;
                    }
                }
                lastIndexOf0 = i;
            }
        }

        if (lastIndexOf0 == -100) { // P 에 해당하는 숫자
            long num = Long.parseLong(convertedNumber);
            if (num != 1 && isPrime(num)) {
                answer++;
            }
        } else if (lastIndexOf0 != convertedNumber.length() - 1) { // 0P 에 해당하는 숫자
            long num = Long.parseLong(convertedNumber.substring(lastIndexOf0 + 1));
            if (num != 1 && isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
