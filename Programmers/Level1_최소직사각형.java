class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            // 길이가 긴 것을 width로 판단
            if (size[0] > size[1]) {
                maxWidth = Math.max(maxWidth, size[0]);
                maxHeight = Math.max(maxHeight, size[1]);
            } else {
                maxWidth = Math.max(maxWidth, size[1]);
                maxHeight = Math.max(maxHeight, size[0]);
            }
        }

        return maxWidth * maxHeight;
    }
}
