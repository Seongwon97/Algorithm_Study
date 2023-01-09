package chapter14_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 실패율
// https://school.programmers.co.kr/learn/courses/30/lessons/42889
public class Ch14_sort_Q25 {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] solution = solution(N, stages);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] reachedNumberPerStage = new int[N + 2];
        int[] remainNumberPerStage = new int[N + 2];

        for (int stage : stages) {
            remainNumberPerStage[stage]++;
            for (int i = stage; i > 0; i--) {
                reachedNumberPerStage[i]++;
            }
        }

        List<Stage> stageInfos = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            float failureRate = (float) remainNumberPerStage[i] / reachedNumberPerStage[i];
            stageInfos.add(new Stage(i, failureRate));
        }

        Collections.sort(stageInfos);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageInfos.get(i).stage;
        }

        return answer;
    }

    public static class Stage implements Comparable<Stage> {
        int stage;
        float failureRate;

        public Stage(int stage, float failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failureRate < o.failureRate) {
                return 1;
            } else if (this.failureRate > o.failureRate) {
                return -1;
            } else {
                return this.stage - o.stage;
            }
        }
    }
}

/*
입력값 〉	5, [2, 1, 2, 6, 2, 4, 3, 3]
기댓값 〉	[3, 4, 2, 1, 5]
---
입력값 〉	4, [4, 4, 4, 4, 4]
기댓값 〉	[4, 1, 2, 3]
 */
