import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bufferedReader.readLine());

        String dice = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(dice);

        int[] diceNumber = new int[6];
        for (int i = 0; i < diceNumber.length; i++) {
            diceNumber[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (N == 1) {
            int max = Integer.MIN_VALUE;
            long result = 0;
            for (int i = 0; i < 6; i++) {
                max = Math.max(max, diceNumber[i]);
                result += diceNumber[i];
            }
            System.out.println(result - max);
            return;
        }

        int minOneSpace = Arrays.stream(diceNumber).min().getAsInt();
        int minSumOfTwoSpace = getMinSumOfTwoSpace(diceNumber);
        int minSumOfThreeSpace = getMinSumOfThreeSpace(diceNumber);

        System.out.println(getResult(N, minOneSpace, minSumOfTwoSpace, minSumOfThreeSpace));
    }

    private static int getMinSumOfTwoSpace(final int[] diceNumber) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if ((i + j) == 5) {
                    continue;
                }
                if ((diceNumber[i] + diceNumber[j]) < minNum) {
                    minNum = diceNumber[i] + diceNumber[j];
                }
            }
        }
        return minNum;
    }

    private static int getMinSumOfThreeSpace(final int[] diceNumber) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    if ((i + j) == 5 || (i + k) == 5 || (j + k) == 5) {
                        continue;
                    }
                    if ((diceNumber[i] + diceNumber[j] + diceNumber[k]) < minNum) {
                        minNum = diceNumber[i] + diceNumber[j] + diceNumber[k];
                    }
                }
            }
        }
        return minNum;
    }

    private static long getResult(final long N, final int oneSpace, final int twoSpace, final int threeSpace) {
        long numOfOneSpace = ((N - 2) * (N - 2) * 5) + ((N - 2) * 4);
        long numOfTwoSpace = ((N - 2) * 8) + 4;
        long numOfThreeSpace = 4L;

        long totalOneSpace = numOfOneSpace * oneSpace;
        long totalTwoSpace = numOfTwoSpace * twoSpace;
        long totalThreeSpace = numOfThreeSpace * threeSpace;

        return totalOneSpace + totalTwoSpace + totalThreeSpace;
    }
}

