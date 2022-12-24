package chapter3_greedy;

import java.util.Arrays;

// 떡볶이 떡 만들기
public class Ch7_binarySearch_ex2 {

    public static void main(String[] args) {
        int target = 6;
        int[] items = {19, 15, 10, 17};
        int answer = solution(items, target);
        System.out.println(answer);
    }

    private static int solution(int[] items, int target) {
        Arrays.sort(items);
        int start = 0;
        int end = items[items.length - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int totalLength = totalLength(items, mid);
            if (totalLength < target) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    private static int totalLength(int[] items, int cuttingLength) {
        int totalLength = 0;
        for (int item : items) {
            int length = item - cuttingLength;
            if (length > 0) {
                totalLength += length;
            }
        }
        return totalLength;
    }
}
