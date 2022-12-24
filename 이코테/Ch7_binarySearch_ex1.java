package chapter3_greedy;

import java.util.Arrays;
// 부품 찾기
public class Ch7_binarySearch_ex1 {

    public static void main(String[] args) {
        int[] items = {8, 3, 7, 9, 2};
        int[] itemsToBuy = {5, 7, 9};
        boolean[] answer = solution(items, itemsToBuy);
        for (boolean b : answer) {
            System.out.print(b + " ");
        }
    }

    private static boolean[] solution(int[] items, int[] itemsToBuy) {
        Arrays.sort(items);
        boolean[] answer = new boolean[itemsToBuy.length];

        for (int i = 0; i < itemsToBuy.length; i++) {
            answer[i] = binarySearch(items, itemsToBuy[i]);
        }

        return answer;
    }

    private static boolean binarySearch(int[] items, int target) {
        int start = 0;
        int end = items.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (items[mid] == target) {
                return true;
            } else if (items[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
