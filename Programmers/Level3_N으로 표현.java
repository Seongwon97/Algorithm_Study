package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            map.put(i, new HashSet<>());
        }

        // 숫자 한 개로 만들 수 있는 숫자는 N만 존재
        map.get(1).add(N);

        for (int i = 2; i <= 9; i++) {
            Set<Integer> countSet = map.get(i);
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = map.get(j);
                Set<Integer> postSet = map.get(i - j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (int i = 1; i <= 9; i++) {
            if (map.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
