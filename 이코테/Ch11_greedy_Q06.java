package chapter3_greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 무지의 먹방 라이브 (Greedy)
class Solution {
    public int solution(int[] food_times, long k) {
        long sumOfTimes = 0;
        for (int time : food_times) {
            sumOfTimes += time;
        }

        if (sumOfTimes <= k) {
            return -1;
        }

        Queue<Food> foods = new PriorityQueue<>();

        for (int i = 1; i < food_times.length + 1; i++) {
            foods.add(new Food(i, food_times[i - 1]));
        }

        long total = 0;
        long previous = 0;
        long length = food_times.length;

        while (total + ((foods.peek().time - previous) * length) <= k) {
            int now = foods.poll().time;
            total += (now - previous) * length;
            length -= 1;
            previous = now;
        }
        List<Food> remainFoods = new ArrayList<>(foods);
        remainFoods.sort(Comparator.comparingInt(o -> o.id));

        return remainFoods.get((int) ((k - total) % length)).id;
    }
}

class Food implements Comparable<Food> {

    int id;
    int time;

    public Food(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}
