import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monsterSpecies = new HashSet<>();
        for (int num : nums) {
            monsterSpecies.add(num);
        }

        if (monsterSpecies.size() >= (nums.length / 2)) {
            return nums.length / 2;
        }

        return monsterSpecies.size();
    }
}
