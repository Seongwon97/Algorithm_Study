package chapter3_greedy;

import java.util.Arrays;
import java.util.Collections;

public class Ch6_sort_ex1 {

    public static void main(String[] args) {
        int[] arr = {3, 15, 27, 12};

        int[] answer = solution(arr);
        for (int i : answer) {
            System.out.print(i + "  ");
        }
    }

    private static int[] solution(int[] arr) {
        Integer[] answer = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        Arrays.sort(answer, Collections.reverseOrder());

        return Arrays.stream(answer)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
